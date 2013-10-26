public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int N = s.length();
        boolean f[] = new boolean[N + 1];
        f[0] = true;

        OUT:
        for (int i = 1; i <= N; i++) {
            for (String str : dict) {
                int len = str.length();
                if (len > i || f[i - len] == false)
                    continue;
                
                String subStr = s.substring(i - len, i);
                if (subStr.equals(str)) {
                    f[i] = true;
                    continue OUT;
                }
            }
        }
        return f[N];
    }
}