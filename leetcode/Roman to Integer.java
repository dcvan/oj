public class Solution {
    int nums[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String strs[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    public int romanToInt(String s) {
        int num = 0;
        int N = nums.length;
        while (s.length() > 0) {
            for (int i = N - 1; i >= 0; i--) {
                if (s.substring(0, Math.min(s.length(), strs[i].length())).equals(strs[i])) {
                    num += nums[i];
                    s = s.substring(strs[i].length());
                    break;
                }
            }
        }
        return num;
    }
}