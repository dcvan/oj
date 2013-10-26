public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
        	result = Math.max(result, prices[i] - min);
        	min = Math.min(min, prices[i]);
        }
        return result;
    }
}