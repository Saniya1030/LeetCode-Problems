class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
              if(grid[i][j]=='1' && !visited[i][j])
              {
                count++;
                bfs(i,j,grid,visited);
              }
            }
        }
        return count;
    }
    private void bfs(int i,int j,char[][] grid,boolean [][]visited)
    {
        int n=grid.length;
        int m=grid[0].length;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        Queue<int []>q=new LinkedList<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];
            for(int k=0;k<4;k++)
            {
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]=='1' && !visited[newRow][newCol])
                {
                    visited[newRow][newCol]=true;
                    q.offer(new int[]{newRow,newCol});
                }
            }

        }

    }
}