import java.util.*;
class Pair{
    int first;
    int second;
    public Pair(int first , int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public static void bfs(int ro , int co , int[][] visit,char[][] grid,int delRow[],int delCol[])
    {
        int n = grid.length;
        int m = grid[0].length;
        visit[ro][co]= 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i = 0; i < 4 ; i++)
            {
                
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == '1' && visit[nrow][ncol] ==0)
                {
                    visit[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
                
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        int visit[][] = new int[n][m];
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == '1' && visit[i][j] == 0)
                {
                    cnt++;
                    bfs(i,j,visit,grid,delRow,delCol);
                }
            }
        }
        return cnt;
    }
}