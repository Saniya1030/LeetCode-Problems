class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int m=grid1[0].length;
        int count=0;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid2[i][j]==1 && !visited[i][j] )
                {
              
                    if(bfs(i,j,grid2,grid1,visited))
                    {
                              count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean bfs(int i, int j,int grid2[][],int grid1[][],boolean visited[][])
    {
        int n=grid1.length;
        int m=grid1[0].length;
        Queue<int []>q=new LinkedList<>();
       boolean subisland=true;
        q.offer(new int[]{i,j});
        visited[i][j]=true;
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];

            int drow[]={-1,0,+1,0};
            int dcol[]={0,+1,0,-1};
            if(grid1[row][col]==0)
            {
                subisland=false;
            }
            for(int k=0;k<4;k++)
            {
                int nrow=row+drow[k];
                int ncol=col+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid2[nrow][ncol]==1 &&  visited[nrow][ncol]==false)
                {
                    visited[nrow][ncol]=true;
                    q.offer(new int[]{nrow,ncol});
                }
            }
        }
        return subisland;
    }
}