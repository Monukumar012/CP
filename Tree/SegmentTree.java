import java.util.*;

class SegmentTree{
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


// Segment Tree with Lazy propogation
class LazySegmentTree{
    int segArr[],lazy[];
    int N;

    LazySegmentTree(int n){
        N=n;
        segArr=new int[4*n+1];
        lazy=new int[4*n+1];
    }

    void build(int arr[]){
        build(0,0,N-1,arr);
    }

    void build(int ind, int low, int high, int arr[]){
        if(low==high){
            segArr[ind]=arr[low];
            return;
        }
        int mid=low+(high-low)/2;

        build(2*ind+1, low, mid, arr);
        build(2*ind+2, mid+1, high, arr);

        segArr[ind] = segArr[2*ind+1]+segArr[2*ind+2];
    }

    void update(int l,int r, int val){
        update(0, 0, N-1, l, r, val);
    }

    void update(int ind, int low, int high, int l, int r, int val){

        //No OverLap - [low  high  l  h] | [l  h  low high]
        if(l>high || r<low)return;

        // Completely OverLap [l  low  high  h]
        if(low>=l && high<=r){
            int nodes = high-low+1;
            segArr[ind]+= nodes*val;

            //Propogate Down if down exist
            if(low!=high){
                lazy[2*ind+1] = val;
                lazy[2*ind+2] = val;
            }
            return;
        }

        int mid=low+(high-low)/2;

        update(2*ind+1, low , mid, l, r, val);
        update(2*ind+2, mid+1 , high, l, r, val);

        segArr[ind]=segArr[2*ind+1]+segArr[2*ind+2];
    }

    int query(int l, int r){
        return query(0, 0, N-1, l, r);
    }

    int query(int ind, int low, int high, int l, int r){

        // No Overlap
        if(high<l || low>r)return 0;

        // Completely overlap
        if(low>=l && high<=r){

            if(lazy[ind]!=0){
                int nodes = high-low+1;
                segArr[ind]=nodes*lazy[ind];
                if(low!=high){
                    lazy[2*ind+1] = lazy[ind];
                    lazy[2*ind+2] = lazy[ind];
                }
                lazy[ind]=0;
            }
            return segArr[ind];
            
        }

        // Partialy overlap

        int mid=low+(high-low)/2;

        int left=query(2*ind+1, low, mid, l, r);
        int right=query(2*ind+2, mid+1, high, l, r);
        return left+right;

    }

}


// for testing segment tree 
class Main{

    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        LazySegmentTree seg=new LazySegmentTree(n);
        seg.build(arr);

        System.out.println("Enter How many query ");
        int t=sc.nextInt();

        while(t-->0){
            System.out.println("Type 1 : for get Sum in Given Range \nType 2 : for Update value in Range");
            int type=sc.nextInt();
            if(type==1){
                System.out.println("Enter Range ");
                int l=sc.nextInt();
                int r=sc.nextInt();
                int sum=seg.query(l,r);

                System.out.println("Sum Value B/W "+l+" to "+r+" -> "+sum);
            }
            else if(type==2){
                System.out.println("Enter range and Value ");
                int i=sc.nextInt();
                int r=sc.nextInt();
                int val=sc.nextInt();
                seg.update(i,r,val);

                int sum=seg.segArr[0];
                System.out.println("After Updating Range "+val+" at "+i+" total Sum is -> "+sum);
            }
            else {
                System.out.println("Invalid Query");
            }

        }
    }
}