import java.util.*;

public class KruskalMST {

    // find mst sum
    public int kruskalMST(int n,int [][]edges) {
        Dsu dsu=new Dsu(n);
        Arrays.sort(edges,(a,b)->a[2]-b[2]);

        int sum=0;
        for(int e[]:edges){
            if(dsu.find(e[0])!=dsu.find(e[1])){
                dsu.union(e[0], e[1]);
                sum+=e[2];
            }
        }
        return sum;
    }


    class Dsu{
        int size[],par[];
        Dsu(int n){
            size=new int[n+1];
            par=new int[n+1];
            for(int i=0;i<n;i++){
                par[i]=i;
                size[i]=1;
            }  
        }
        // find uplimate parrent - root/boss
        int find(int u){
            if(u==par[u])return u;
            return par[u]=find(par[u]);
        }

        void union(int u ,int v){
            int upu=find(u),upv=find(v);
            if(upu==upv)return;

            if(size[upu]>size[upv]){
                par[upv]=upu;
                size[upu]+=size[upv];
            }
            else{
                par[upu]=upv;
                size[upv]+=size[upu];
            }
        }
    }
}
