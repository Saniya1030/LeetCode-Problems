class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        Queue<int []>q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=0 && !visited[i][j])
                {
                   long sum= bfs(i,j,grid,q,visited);
                   
                    if(sum%k==0)
                    {
                        count++;
                    }
                }
            }
        }
            return count;
        }
        private long bfs(int i, int j,int grid[][],Queue<int[]>q,boolean visited[][])
        {
            int n=grid.length;
            int m=grid[0].length;
            long sum=0;
            q.offer(new int[]{i,j});
            visited[i][j]=true;
            while(!q.isEmpty())
            {
                int ceil[]=q.poll();
                int row=ceil[0];
                int col=ceil[1];
                 sum+=grid[row][col];
                int drow[]={-1,0,+1,0};
                int dcol[]={0,+1,0,-1};
                for(int k=0;k<4;k++)
                {
                    int nrow=row+drow[k];
                    int ncol=col+dcol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]!=0 && !visited[nrow][ncol])
                    {
                        
                        q.offer(new int[]{nrow,ncol});
                        visited[nrow][ncol]=true;
                    }
                }
            }
            return sum;
        }
    }
