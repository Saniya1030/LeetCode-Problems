
import java.util.*;

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        int count = 0;

        // Traverse first and last rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                bfs(0, j, visited, grid);
            }

            if (grid[n - 1][j] == 1 && !visited[n - 1][j]) {
                bfs(n - 1, j, visited, grid);
            }
        }

        // Traverse first and last columns
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                bfs(i, 0, visited, grid);
            }

            if (grid[i][m - 1] == 1 && !visited[i][m - 1]) {
                bfs(i, m - 1, visited, grid);
            }
        }

        // Count land cells that cannot reach the boundary
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, boolean visited[][], int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int cell[] = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];

                if (nrow >= 0 && nrow < n
                        && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == 1
                        && !visited[nrow][ncol]) {

                    q.offer(new int[]{nrow, ncol});
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
}
