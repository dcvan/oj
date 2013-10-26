public class Solution {
    public int maxSubArray(int[] A) {
        int N = A.length;
        if (N == 0)
        	return 0;

        int temp = A[0];
        int MAX_VAL = A[0];
        for (int i = 1; i < N; i++){
        	if (temp > 0)
        		temp += A[i];
        	else
        		temp = A[i];
        	if (temp > MAX_VAL)
        		MAX_VAL = temp;
        }
        return MAX_VAL;
    }
}