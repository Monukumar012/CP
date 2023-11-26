import java.util.*;


public class DFS {

    void dfs(int u, int n, List<List<Integer>> adj){
        boolean vis[]=new boolean[n+1];
        dfs(u,adj,vis);
    }
    
    void dfs(int u, List<List<Integer>> adj, boolean vis[]){
        vis[u]=true;

        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(v,adj,vis);
            }
        }
    }
}
