import java.util.*;

public class SegmentTree{
    public int segmentArr[];
    public int N;
    SegmentTree(int n){
        N=n;
        segmentArr=new int[4*n+1];
    }

    public void build(int arr[]){
        build(0,0,N-1,arr);
    }

    public int query(int l, int r){
        return query(0,0,N-1,l,r);
    }

    public void update(int i,int val){
        update(0,0,N-1,i,val);
    }

    public void build(int ind,int low, int high, int arr[]){
        if(low==high){
            segmentArr[ind]=arr[low];
            return;
        }

        int mid=(low+high)/2;
        build(2*ind+1,low,mid,arr);
        build(2*ind+2,mid+1,high,arr);

        segmentArr[ind]=Math.max(segmentArr[2*ind+1],segmentArr[2*ind+2]);
    }

    public int query(int ind,int low, int high,int l, int r){
        // Complete Overlap [l   low   high   r]
        if(low>=l && high<=r)return segmentArr[ind];

        // No Overlap  [low   high  l   r]  || [l  r  low   high]
        if(r<low || l>high)return Integer.MIN_VALUE;

        // Partially overlap   [low  l  high   r]  || [l   low   r   high]
        int mid=low+(high-low)/2;
        int left=query(2*ind+1,low,mid,l,r);
        int right = query(2*ind+2,mid+1,high,l,r);

        return Math.max(left,right);
    }

    public void update(int ind, int low, int high, int i, int val){
        if(low==high){
            segmentArr[ind]=val;
            return;
        }

        int mid=low+(high-low)/2;

        // Given pos in left
        if(i<=mid) update(2*ind+1, low, mid, i, val);
        // Given pos in right
        else update(2*ind+2, mid+1, high, i, val);

        // Update root after updating [2*ind+1] or [2*ind+2]
        segmentArr[ind]=Math.max(segmentArr[2*ind+1], segmentArr[2*ind+2]);
    }

}


// for testing segment tree 
class Main{

    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        SegmentTree seg=new SegmentTree(n);
        seg.build(arr);


        System.out.println("Enter How many query ");
        int t=sc.nextInt();

        while(t-->0){
            System.out.println("Type 1 : for get Maximum in Given Range \nType 2 : for Update value at Index");
            int type=sc.nextInt();
            if(type==1){
                System.out.println("Enter Range ");
                int l=sc.nextInt();
                int r=sc.nextInt();
                int max=seg.query(l,r);

                System.out.println("Max Value B/W "+l+" to "+r+" -> "+max);
            }
            else if(type==2){
                System.out.println("Enter Postion and Value ");
                int i=sc.nextInt();
                int val=sc.nextInt();
                seg.update(i,val);

                int max=seg.segmentArr[0];
                System.out.println("After Updating Value "+val+" at "+i+" Max is -> "+max);
            }
            else {
                System.out.println("Invalid Query");
            }

        }
    }
}