public class Solution {
    // s3 = s1 + s2
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;

        int M = s1.length();
        int N = s2.length();
        if (s3.length() != M + N)
            return false;

        boolean f[][] = new boolean[M + 1][N + 1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                    continue;
                }

                if (i >= 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    f[i][j] |= f[i - 1][j];
                if (j >= 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    f[i][j] |= f[i][j - 1];
            }
        }
        return f[M][N];
    }
}