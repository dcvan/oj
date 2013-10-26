public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();
        if (nRows == 1 || len <= nRows)
            return s;

        StringBuffer result = new StringBuffer("");
        int num = 2 * (nRows - 1);
        
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < len; j+=num) {
                result.append(s.substring(j, j + 1));
                int k = num - 2 * (j % num) + j;
                if (i > 0 && i < nRows - 1 && k < len)
                    result.append(s.substring(k, k + 1));
            }
        }
        return result.toString();
    }
}