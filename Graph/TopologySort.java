import java.util.*;

class TopologySort {

    List<Integer> kahns(int n, List<List<Integer>> adj) {
        int inDeg[]=new int[n];
        for(List<Integer> u:adj){
            for(int v:u)inDeg[v]++;
        }
        List<Integer> ans=new ArrayList<>();
        
        Queue<Integer> q=new LinkedList<>();
        // Add which have indegree 0
        for(int i=0;i<n;i++){
            if(inDeg[i]==0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int u=q.poll();
            ans.add(u);
            
            for(int v:adj.get(u)){
                if(--inDeg[v]==0)q.add(v);
            }
        }
        return ans;
    }


    List<Integer> topoSortDfs(int n, List<List<Integer>> adj){
        boolean vis[]=new boolean[n];
        List<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            if(!vis[i])dfs(i, vis, adj, st);
        }
        
        while(!st.isEmpty())ans.add(st.pop());

        return ans;
    }

    void dfs(int u, boolean vis[], List<List<Integer>> adj, Stack<Integer> st){
        vis[u]=true;
        
        for(int v:adj.get(u)){
            if(!vis[v])dfs(v,vis,adj,st);
        }
        st.add(u);
    }

}
