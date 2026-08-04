class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // Traverse first and last row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[n - 1][i] == 'O') {
                dfs(n - 1, i, board);
            }
        }

        // Traverse first and last column
        for (int j = 0; j < n; j++) {
            if (board[j][0] == 'O') {
                dfs(j, 0, board);
            }
            if (board[j][m - 1] == 'O') {
                dfs(j, m - 1, board);
            }
        }

        // Convert board
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {

                if (board[a][b] == 'T') {
                    board[a][b] = 'O';
                } else if (board[a][b] == 'O') {
                    board[a][b] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // Boundary check
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') {
            return;
        }

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        board[i][j] = 'T';

        for (int k = 0; k < 4; k++) {
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];

            dfs(newRow, newCol, board);
        }
    }
}