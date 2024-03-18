import java.util.*;
class Solution {
    public static void dfs(int node , boolean vis[] , ArrayList<ArrayList<Integer>> graph)
    {
        vis[node] = true;

        for(Integer it : graph.get(node))
        {
            if(!vis[it])
            {
                dfs(it,vis,graph);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        // to change adjacency matrix to list
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    graph.get(i).add(j);
                    // graph.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                count++;
                dfs(i,vis,graph);
            }
        }
        return count;
    }
}