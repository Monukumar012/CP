import java.util.*;


public class BFS {
    
    void bfs(int node, List<List<Integer>> adj, int n){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n+1];
        q.add(node);
        vis[node]=true;

        while(!q.isEmpty()){
            int u=q.poll();

            for(int v:adj.get(u)){
                if(!vis[v]){
                    q.add(v);
                    vis[v]=true;
                }
            }
        }
    }
}
