class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)
                {
                    q.offer(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
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
                int newRow=delRow[k]+row;
                int newCol=delCol[k]+col;
                if(newRow>=0 && newRow<n &&newCol>=0 && newCol<m && mat[newRow][newCol]==-1)
                {
                    mat[newRow][newCol]=mat[row][col]+1;
                    q.offer(new int[]{newRow,newCol});
                }
            }
        }
        return mat;
    }
}