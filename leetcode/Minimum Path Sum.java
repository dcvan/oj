public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int M = grid.length;
        int N = grid[0].length;
        for (int i = 1; i < M; i++)
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < N; i++)
            grid[0][i] += grid[0][i - 1];

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                grid[i][j] = Math.min(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j]);
            }
        }
        return grid[M - 1][N - 1];
    }
}