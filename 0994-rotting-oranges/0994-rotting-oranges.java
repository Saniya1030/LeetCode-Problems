class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
        int time=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j,0});
                    visited[i][j]=true;
                }  
            }
        }
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];
         time=ceil[2];
            max=Math.max(time,max);
            int drow[]={-1,0,+1,0};
            int dcol[]={0,+1,0,-1};
            for(int k=0;k<4;k++)
            {
                int nrow=row+drow[k];
                int ncol=col+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==false)
                {
                    q.offer(new int[]{nrow,ncol,time+1});
                    visited[nrow][ncol]=true;
                    grid[nrow][ncol]=2;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
            if(grid[i][j]==1)
            {
                return -1;
            }
        }
        }
        return max;
    }
    
}