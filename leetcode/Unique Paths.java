public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int num[][] = new int[m][n];

        num[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0)
                    num[i][j] = num[i][j - 1];
                else if (j == 0)
                    num[i][j] = num[i - 1][j];
                else
                    num[i][j] = num[i - 1][j] + num[i][j - 1];
            }
        }
        return num[m - 1][n - 1];
    }
}