class SgTree{
    public class Node{
        long pre,suf,max,sum;
        Node(long val){
            pre=max=sum=suf=val;
        }
    }
    
    Node seg[];
    int N;
    SgTree(int n){
        seg=new Node[4*n+1];
        N=n;
    }
    
    Node merge(Node left, Node right){
        Node node=new Node(0);
        node.pre=Math.max(left.pre, left.sum+right.pre);
        node.suf=Math.max(right.suf, left.suf+right.sum);
        node.max=Math.max(Math.max(left.max, right.max),left.suf+right.pre);
        node.sum=left.sum+right.sum;
        
        return node;
    }
    
    
    void build(int ind, int low, int high, int arr[]){
        if(low==high){
            seg[ind]=new Node(arr[low]);
            return;
        }
        int mid=low+(high-low)/2;
        build(2*ind+1, low, mid, arr);
        build(2*ind+2, mid+1, high, arr);
        
        seg[ind]=merge(seg[2*ind+1], seg[2*ind+2]);
    }
    
    Node query(int ind, int low, int high, int l, int r){
        if(low>=l && high<=r)return seg[ind];
        
        if(high<l || low>r)return new Node(Integer.MIN_VALUE);
        
        int mid=low+(high-low)/2;
        
        Node left=query(2*ind+1, low, mid, l,r);
        Node right = query(2*ind+2, mid+1, high, l, r);
        
        return merge(left,right);
    }
}

class MaxSumSubarray{
    public long kMaxSubarray(int n, int k, int arr[]) {
        SgTree sg=new SgTree(n);
        sg.build(0,0,n-1,arr);
        
        long max=Long.MIN_VALUE;
        for(int i=0;i<=n-k;i++){
            Node node=sg.query(0,0,n-1,i,i+k-1);
            max=Math.max(max,node.max);
        }
        return max;

    }
}