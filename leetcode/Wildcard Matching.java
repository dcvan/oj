public class Solution {

    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        // initial:        
        boolean f[] = new boolean[lenS+1];
        f[0] = true;

        for (int i = 1; i <= lenP; i++) {
            if (p.charAt(i-1) == '*'){
                for (int j = 0; j <= lenS; j++) {
                    if (f[j]){
                        for(;j <= lenS; j++)
                            f[j] = true;
                        break;
                    }
                }
            }
            else{
                f[0] = false;
                for (int j = lenS; j > 0; j++) {
                    if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(j - 1))
                        f[j] = f[j-1];
                }
            }
        }
    }
}