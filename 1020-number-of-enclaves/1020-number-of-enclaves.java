class Solution {
    public int numEnclaves(int[][] grid) {
int count=0;
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<m;i++)
        {
            if(grid[0][i]==1)
            {
                dfs(0,i,grid);
            }
            if(grid[n-1][i]==1)
            {
                dfs(n-1,i,grid);
            }
        }
        for(int j=0;j<n;j++)
        {
            if(grid[j][0]==1)
            {
                dfs(j,0,grid);
            }
            if(grid[j][m-1]==1)
            {
                dfs(j,m-1,grid);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i,int j,int grid[][])
    {
        int n=grid.length;
        int m=grid[0].length;
        int drow[]={-1,0,+1,0};
        int dcol[]={0,+1,0,-1};
        grid[i][j]=0;
        for(int k=0;k<4;k++)
        {
            int nrow=i+drow[k];
            int ncol=j+dcol[k];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,grid);
            }
        }
    }
}

// class Solution {
//     public int numEnclaves(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
//         boolean[][] vis=new boolean[m][n];
//         for(int i=0;i<m;i++){
//             if(grid[i][0] == 1 && !vis[i][0]){
//                 bfs(i,0,grid,vis);
//             }
//             if(grid[i][n-1] == 1 && !vis[i][n-1]){
//                 bfs(i,n-1,grid,vis);
//             }
//         }
//         for(int i=0;i<n;i++){
//             if(grid[0][i] == 1 && !vis[0][i]){
//                 bfs(0,i,grid,vis);
//             }
//             if(grid[m-1][i] == 1 && !vis[m-1][i]){
//                 bfs(m-1,i,grid,vis);
//             }
//         }
//         int count=0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==1 && !vis[i][j])
//                 count++;
//             }
//         }
//         return count;
//     }
//     public void bfs(int row, int col, int[][] grid, boolean[][] vis){
//         Queue<int[]> q=new LinkedList<>();
//         int m=grid.length;
//         vis[row][col]=true;
//         int n=grid[0].length;
//         q.add(new int[]{row,col});
//         int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
//         while(!q.isEmpty()){
//             int[] curr=q.poll();
//             for(int[] dir:directions){
//                 int nr=curr[0]+dir[0];
//                 int nc=curr[1]+dir[1];

//                 if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && grid[nr][nc]==1){
//                     vis[nr][nc]=true;
//                     q.add(new int[]{nr,nc});
//                 }
//             }
//         }
//     }
// }