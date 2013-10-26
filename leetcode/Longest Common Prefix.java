public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        if (strs == null || strs.length == 0)
        	return commonPrefix;

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < (i + 1) || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return commonPrefix;
                }
            }
            commonPrefix = strs[0].substring(0, i + 1);
        }
        return commonPrefix;
    }
}