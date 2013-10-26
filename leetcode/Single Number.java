public class Solution {
    public int singleNumber(int[] A) {
        int N = A.length;
        int ans = A[0];

        for (int i = 1; i < N; i++) {
        	ans = ans ^ A[i];
        }
        return ans;
    }
}