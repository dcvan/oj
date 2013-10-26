public class Solution {
    public String strStr(String haystack, String needle) {
        int N = needle.length();
        if (haystack.length() < N)
            return null;
        
        for (int i = 0; i <= haystack.length() - N; i++){
            if (haystack.substring(i, i + N).equals(needle))
                return haystack.substring(i);
        }
        return null;
    }
}