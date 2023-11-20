import java.util.*;

class SegmentTree{
    public int segmentArr[];

    SegmentTree(int n){
        segmentArr=new int[4*n];
    }

    public void segmentBuild(int ind,int low,int high,int arr[]){
        if(low==high){
            segmentArr[ind]=arr[low];
            return;
        }

        int mid=low+(high-low)/2;

        segmentBuild(2*ind+1,low,mid,arr);
        segmentBuild(2*ind+2,mid+1,high,arr);

        segmentArr[ind] = Math.min(segmentArr[2*ind+1],segmentArr[2*ind+2]);
    }

    public int segmentQuery(int ind, int low, int high, int l, int r, int arr[]){
        // Completely Overlap -> [low   l    r    high]
        if(l<=low && r>=high) return segmentArr[ind];

        // Not Overlap -> [low   high   l   r] | [l  r  low  high]
        if(l<high || r>low) return Integer.MAX_VALUE;

        // Partial overlap -> [low  l  high   r] | [l   low  r  high ]
        int mid = low+(high-low)/2;
        int left = segmentQuery(ind*2+1, low, mid, l, r, arr);
        int right = segmentQuery(ind*2+2 ,mid+1, high, l, r, arr);

        return Math.min(left,right);
    }

    public void update(int ind,int low,int high, int i, int val){
        if(low==high){
            segmentArr[ind] = val;
            return;
        }

        int mid = low+(high-low)/2;

        if(i<=mid)update(2*ind+1, low, mid, i, val);
        else update(2*ind+2, low, mid, i, val);

        segmentArr[ind] = Math.min(segmentArr[2*ind+1],segmentArr[2*ind+2]);
    }

}