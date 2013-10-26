public class Solution {
    public int maxProfit(int[] prices) {
       	int N = prices.length;
        int numL[] = new int[N];
        int numR[] = new int[N];

        // from left to right:
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
        	min = Math.min(min, prices[i]);
        	numL[i] = Math.max(0, prices[i] - min);
        	if (i > 0)
        		numL[i] = Math.max(numL[i], numL[i-1]);
        }
    	// from right to left:
        int max = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
        	max = Math.max(max, prices[i]);
        	numR[i] = Math.max(0, max - prices[i]);
        	if (i < N - 1)
        		numR[i] = Math.max(numR[i], numR[i+1]);
        }

        // get the max:
        int ans = 0;
        for (int i = 0; i < N; i++)
			ans = Math.max(ans, numL[i] + numR[i]);
		return ans;
    }
}