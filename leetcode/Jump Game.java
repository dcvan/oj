public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0)
            return false;

        int N = A.length;
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            if (maxVal < i)
                return false;
            maxVal = Math.max(maxVal, i + A[i]);
        }
        return true;
    }
}