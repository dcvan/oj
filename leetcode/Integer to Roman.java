public class Solution {
    int nums[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String strs[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    public String intToRoman(int num) {
        String result = "";
        int n = nums.length;
        while (num > 0) {
            for (int k = n - 1; k >= 0; k--) {
                if (num >= nums[k]) {
                    num -= nums[k];
                    result += strs[k];
                    break;
                }
            }
        }
        return result;
    }
}