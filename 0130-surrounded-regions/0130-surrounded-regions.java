class Solution {
    public void solve(char[][] board) {
        Queue<int[]>q=new LinkedList<>();
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || j==0||i==n-1 ||j==m-1)
                {
                    if(board[i][j]=='O')
                    {
                        q.offer(new int[]{i,j});
                        board[i][j]='M';
                    }
                }
            }
        }
        while(!q.isEmpty())
        {
            int ceil[]=q.poll();
            int row=ceil[0];
            int col=ceil[1];
            board[row][col]='M';
            int drow[]={-1,0,+1,0};
            int dcol[]={0,+1,0,-1};
            for(int k=0;k<4;k++)
            {
                int nrow=row+drow[k];
                int ncol=col+dcol[k];
                if(nrow>=0  && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O')
                {
                    board[nrow][ncol]='M';
                    q.offer(new int[]{nrow,ncol});
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='M')
                {
                    board[i][j]='O';
                }
                 else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
    }
}