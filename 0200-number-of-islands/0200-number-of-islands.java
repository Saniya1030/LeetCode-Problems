class Solution {
    public int numIslands(char[][] grid) {
        boolean visited[][]=new boolean [grid.length][grid[0].length];
        Queue<int[]>q=new LinkedList<>();
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    count++;
                    visited[i][j]=true;
                    bfs(q,i,j,grid,visited);
                }
            }
        }
        return count;

    }
    private void bfs(Queue<int[]>q,int i,int j,char grid[][],boolean visited[][])
    {
        int  n=grid.length;
        int m=grid[0].length;
      
        q.offer(new int[]{i,j});
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];

            int delRow[]={-1,0,+1,0};
            int delCol[]={0,+1,0,-1};
            for(int k=0;k<4;k++)
            {
                int newRow=delRow[k]+row;
                int newCol=delCol[k]+col;
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]=='1' && visited[newRow][newCol]==false)
                {
                    visited[newRow][newCol]=true;
                    q.offer(new int[]{newRow,newCol});
                }
            }

        }
    }
}