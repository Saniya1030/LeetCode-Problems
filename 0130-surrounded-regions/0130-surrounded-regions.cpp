class Solution {
public:
vector<int>dr={-1,0,1,0};
vector<int>dc={0,1,0,-1};
    void solve(vector<vector<char>>& mat) {
        int n=mat.size();
       int m=mat[0].size();
       queue<pair<int,int>>q;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(i==0 || j==0 || i==n-1 || j==m-1){
                if(mat[i][j]=='O'){
                    q.push({i,j});
                }
            }
        }
       }
       while(!q.empty()){
        int r=q.front().first;
        int c=q.front().second;
        q.pop();
        // if(mat[r][c]=='M'){
        //     continue;
        // }
        mat[r][c]='M';
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]=='O'){
                mat[nr][nc]='M';
                q.push({nr,nc});
            }
        }
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(mat[i][j]=='M'){
                mat[i][j]='O';
            }
            else if(mat[i][j]=='O'){
                mat[i][j]='X';
            }
        }
       }
    }
};