class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
   
        Queue<int[]>q=new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0 && !visited[i][j])
                {
                   if (bfs(q,i,j,visited,grid))
                   {
                    count++;
                }
                }
            }
        }
        return count;
    }
    private boolean bfs(Queue<int[]>q,int i,int j,boolean visited[][],int grid[][])
    {
        int n=grid.length;
        int m=grid[0].length;
           boolean closed=true;
                   q.offer(new int[]{i,j});
        visited[i][j]=true;
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];

            int drow[]={-1,0,+1,0};
            int dcol[]={0,+1,0,-1};
            if(row==0 || row==n-1 ||col==0||col==m-1)
            {
                
                closed=false;
            }
            for(int k=0;k<4;k++)
            {
                int newRow=drow[k]+row;
                int newCol=dcol[k]+col;
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]==0 && !visited[newRow][newCol])
                {
                    q.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol]=true;
                }
            }
            
        }
        return closed;
    }
}