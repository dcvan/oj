public class Solution {
    public int candy(int[] ratings) {
    	int N = ratings.length;
    	if (N == 0)
    		return 0;

		int up[]   = new int[N];
		int down[] = new int[N];

		up[0] = 1;
		for (int i = 1; i < N; i++) {
			if (ratings[i] > ratings[i - 1])
				up[i] = up[i - 1] + 1;
			else
				up[i] = 1;
		}

		down[N - 1] = 1;
		for (int i = N-2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				down[i] = down[i + 1] + 1;
			else
				down[i] = 1;
		}

		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += Math.max(up[i], down[i]);
		
		return sum;
    }
}	