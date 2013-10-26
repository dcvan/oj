public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
            return 0;

        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        int num[][] = new int[M][N];

        num[0][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (obstacleGrid[i][j] == 1)
                    num[i][j] = 0;
                else if (i == 0)
                    num[i][j] = num[i][j - 1];
                else if (j == 0)
                    num[i][j] = num[i - 1][j];
                else
                    num[i][j] = num[i - 1][j] + num[i][j - 1];
            }
        }
        return num[M - 1][N - 1];
    }
}