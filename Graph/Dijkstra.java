import java.util.*;


public class Dijkstra {

    // src to dest shortest path
    int dijkstra(int src,int dest, List<List<int[]>> adj,int n){
        int dis[]=new int[n];
        Arrays.fill(dis, (int)1e9);

        Queue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0});
        dis[src]=0;

        while(!pq.isEmpty()){
            int u=pq.peek()[0], cost = pq.poll()[1];

            if(u==dest)return cost;

            for(int p[] : adj.get(u)){
                int v=p[0], currCost=p[1];

                if(dis[v]>dis[u]+currCost){
                    dis[v]=dis[u]+currCost;
                    pq.add(new int[]{v, dis[v]});
                }
            }
        }
        return -1;
    }

    // src to dest shortest path with at max using k adj
    int dijkstra(int src,int dest, int k, List<List<int[]>> adj,int n){
        int dis[]=new int[n];
        Arrays.fill(dis, (int)1e9);

        Queue<int[]> pq=new LinkedList<>();
        pq.add(new int[]{src,k,0});
        dis[src]=0;

        while(!pq.isEmpty()){
            int u=pq.peek()[0], kk=pq.poll()[1];

            if(kk==0)continue;

            for(int p[] : adj.get(u)){
                int v=p[0], currCost=p[1];

                if(kk>0 && dis[v]>dis[u]+currCost){
                    dis[v]=dis[u]+currCost;
                    pq.add(new int[]{v, kk-1});
                }
            }
        }
        return dis[dest] == (int)1e9 ? -1 : dis[dest];
    }

    // get src to all dest shotest path array
    int[] dijkstra(int src, List<List<int[]>> adj,int n){
        int dis[]=new int[n];
        Arrays.fill(dis, (int)1e9);

        Queue<Integer> pq=new LinkedList<>();
        pq.add(src);
        dis[src]=0;

        while(!pq.isEmpty()){
            int u=pq.poll();

            for(int p[] : adj.get(u)){
                int v=p[0], currCost=p[1];

                if(dis[v]>dis[u]+currCost){
                    dis[v]=dis[u]+currCost;
                    pq.add(v);
                }
            }
        }
        return dis;
    }

}
