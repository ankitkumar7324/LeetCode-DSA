import java.util.*;

class Pair{
    int row;
    int col;
    int tm;
    public Pair(int row , int col , int tm)
    {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cntFresh = 0;
        int visit[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i,j,0));
                    visit[i][j] = 2;
                }
                else
                {
                    visit[i][j] = 0;
                }

                if(grid[i][j] == 1)
                {
                    cntFresh++;
                }


            }
        }

        int time =0;
        int cnt = 0;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};

        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            int tm = q.peek().tm;
            q.remove();
            time = Math.max(time , tm);

            for(int i=0;i<4;i++)
            {
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visit[nrow][ncol] == 0)
                {
                    visit[nrow][ncol] = 2;
                    q.add(new Pair(nrow,ncol,tm+1));
                    cnt++;
                } 
            }
        }
        if(cnt != cntFresh)
        {
            return -1;
        }
        return time;
    }
}