import java.util.*;

public class BuildAdjancey {


    List<List<Integer>> buildAdjancey(int edges[][],int n){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        return adj;
    }


    List<List<int[]>> buildAdjanceyWithCost(int edges[][],int n){
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        for(int e[]:edges){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
            adj.get(e[1]).add(new int[]{e[0],e[2]});
        }

        return adj;
    }
}
