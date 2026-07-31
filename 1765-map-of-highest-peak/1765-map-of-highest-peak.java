class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        Queue<int[]>q=new LinkedList<>();
        int height[][]=new int[n][m];
       
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(isWater[i][j]==1)
                {
                    height[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else{
                    height[i][j]=-1;
                }
            }
        }
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};

        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];
            for(int k=0;k<4;k++)
            {
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && height[newRow][newCol]==-1)
                {
                    height[newRow][newCol]=height[row][col]+1;
                    q.offer(new int []{newRow,newCol});
                }
            }

        }
         
        return height;


    }
}