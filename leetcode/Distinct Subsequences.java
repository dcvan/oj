public class Solution {
    public int numDistinct(String S, String T) {
        int M = S.length();
        int N = T.length();

        int f[][] = new int[M + 1][N + 1];

        for (int i = 0; i <= M ; i++) {
            f[i][0] = 1;
        }

        // f[i][j] = f[i-1][j-1] || f[i-1][j]
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                f[i][j] = f[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1))
                    f[i][j] += f[i - 1][j - 1];
            }
        }
        return f[M][N];
    }
}