public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        while (s.length() > 0 && s.charAt(s.length() - 1) == ' ')
            s = s.substring(0, s.length() - 1);

        int i = 0;
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;
        }
        return s.length() - i - 1;
    }
}