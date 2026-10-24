class Solution {
    public int[][] updateMatrix(int[][] mat) {
     int n=mat.length;
     int m=mat[0].length;
     Queue<int[]>q=new LinkedList<>();
     for(int i=0;i<n;i++)
     {
        for(int j=0;j<m;j++)
        {
            if(mat[i][j]==0)
            {
                q.offer(new int[]{i,j});
            }
            else {
                mat[i][j]=-1;
            }
        }
     } 
     int drow[]={-1,0,+1,0};
     int dcol[]={0,+1,0,-1};
     while(!q.isEmpty())
     {
        int ceil[]=q.poll();
        int row=ceil[0];
        int col=ceil[1];
        for(int k=0;k<4;k++)
        {
            int nrow=row+drow[k];
            int ncol=col+dcol[k];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==-1)
            {
                mat[nrow][ncol]=mat[row][col]+1;
                q.offer(new int[]{nrow,ncol});
            }
        }
     } 
     return mat;
    }
}