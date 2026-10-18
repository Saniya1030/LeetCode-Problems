class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        Queue<int[]>q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
         int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }
        if(!visited[sr][sc])
        {
            bfs(sr,sc,image,visited,color,originalColor);
        }
      return image;
    }
    private void  bfs(int sr,int sc,int [][]image,boolean visited[][],int color, int originalColor)
    {
        int n=image.length;
        int m=image[0].length;
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{sr,sc});
        visited[sr][sc]=true;
        image[sr][sc]=color;
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];
            int drow[]={-1,0,+1,0};
            int dcol[]={0,+1,0,-1};
            for(int k=0;k<4;k++)
            {
                int nrow=row+drow[k];
                int ncol=col+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==originalColor && !visited[nrow][ncol])
                {
                    q.offer(new int[]{nrow,ncol});
                    visited[nrow][ncol]=true;
                    image[nrow][ncol]=color;

                }
            }
        }
    }
}
