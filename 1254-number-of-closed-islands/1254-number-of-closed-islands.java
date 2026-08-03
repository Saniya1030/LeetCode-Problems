class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        int count=0;
         for(int i=0;i<n;i++)
         {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0 && visited[i][j]!=true)
                {
                    if(                    bfs(i,j,visited,grid))
                    count++;
                }
            }
         }
         return count;
    }
    private boolean bfs(int i,int j,boolean visited[][],int [][]grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        boolean closed=true;
        Queue<int []>q=new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j]=true;
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];
             if (row == 0 || row == n - 1 || col == 0 || col == m - 1)
                closed = false;
            for(int k=0;k<4;k++)
            {
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];
                
                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]==0 && !visited[newRow][newCol])
                {
                    q.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol]=true;

                }
            }

        }
        return closed;
    }
}