public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int N = s.length();
        int f[] = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                continue;
            f[i] = f[i + 1];
            if (i < N - 1 && Integer.parseInt(s.substring(0, 2)) < 27)
                f[i] += f[i + 2];
        }
        return f[0];
    }
}