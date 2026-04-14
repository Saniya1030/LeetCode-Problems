class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[0][0]=0;
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        pq.offer(new int[]{0,0,0});
        int drow[]={-1,0,+1,0};
        int dcol[]={0,+1,0,-1};
        
        while(!pq.isEmpty())
        {
            int ceil[]=pq.poll();
          
            int effort = ceil[0];
            int row = ceil[1];
            int col = ceil[2];
             if(row == n-1 && col == m-1) return effort;

            for(int i=0;i<4;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m )
                {
                    int newEffort=Math.max(effort,Math.abs(heights[row][col]-heights[nrow][ncol]));
                
                if(newEffort<dist[nrow][ncol])
                {
                    dist[nrow][ncol]=newEffort;
                    pq.offer(new int[]{newEffort,nrow,ncol});
                }
                }
            }


        }
        return 0;
    }
}