class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        int n=grid.length;
        int m=grid[0].length;
        int maxTime=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j,0});

                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        while(!q.isEmpty()){
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];
            int time=ceil[2];
            maxTime=Math.max(maxTime,time);

            for(int k=0;k<4;k++)
            {
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]==1)
                {
                    q.offer(new int[]{newRow,newCol,time+1});
                    fresh--;
                    grid[newRow][newCol]=2;
                }
            }
        }
            if(fresh==0)
            {
                return maxTime;
            }
            else{
                return -1;
            }

        
        
    }
}