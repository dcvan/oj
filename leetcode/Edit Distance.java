public class Solution {
    public int minDistance(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();

        int[][] f = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++)
            f[i][0] = i;
        for (int i = 0; i <= N; i++)
            f[0][i] = i;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    f[i][j] = Math.min(f[i - 1][j - 1], f[i][j]);
                else
                    f[i][j] = Math.min(f[i - 1][j - 1] + 1, f[i][j]);
            }
        }
        return f[M][N];
    }
}