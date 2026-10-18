class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        Queue<int []>q=new LinkedList<>();
        int count=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && !visited[i][j])
                {
                   int area= bfs(i,j,grid,visited);
                   max=Math.max(area,max);
                }
            }
        }
        return max;
    }
    private int bfs(int i,int j,int[][]grid,boolean visited[][])
    {
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int []{i,j});
        visited[i][j]=true;
     int count=1;
        while(!q.isEmpty())
        {
            int []ceil=q.poll();
            int row=ceil[0];
            int col=ceil[1];
  
            int dRow[]={-1,0,+1,0};
            int dCol[]={0,+1,0,-1};
            for(int k=0;k<4;k++)
            {
                int nRow=row+dRow[k];
                int nCol=col+dCol[k];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && !visited[nRow][nCol])
                {
                    visited[nRow][nCol]=true;
                    count++;
                    q.offer(new int[]{nRow,nCol});
                }
            }
        }
        return count;
    }
}