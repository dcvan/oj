public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int N = s.length();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (j < N) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
                continue;
            }
            while (s.charAt(i) != s.charAt(j)){
                set.remove(s.charAt(i));
                i++;
            }
            i++;
            j++;
        }
        return maxLen;
    }
}