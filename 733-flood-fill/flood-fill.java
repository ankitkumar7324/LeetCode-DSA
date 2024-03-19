class Solution {
     public static void dfs(int[][] image, int n, int m, int x, int y, int initColor, int p,int ans[][],int delRow[],int delCol[])
    {
        ans[x][y] = p;

        for(int i=0;i<4;i++)
        {
            int nrow = x+delRow[i];
            int ncol = y+delCol[i];
            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && image[nrow][ncol] == initColor && ans[nrow][ncol] != p)
            {
                dfs( image,  n,  m, nrow, ncol,  initColor,  p,ans,delRow,delCol);
            } 
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initColor = image[sr][sc];
        int ans[][] = image;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};

        dfs( image,  n,  m, sr, sc,  initColor,  color,ans,delRow,delCol);
        return ans;
    }
}