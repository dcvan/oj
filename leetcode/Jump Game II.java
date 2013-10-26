public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int N = A.length;
        int maxVal = 0;
        int step[] = new int[N];
        for (int i = 0; i < N; i++) {
            if (i + A[i] <= maxVal)
                continue;
            for (int index = maxVal + 1; index <= i + A[i] && index < N; index++) {
                if (step[index] == 0 || step[index] > step[i] + 1)
                    step[index] = step[i] + 1;
            }
            maxVal = Math.max(maxVal, i + A[i]);
        }
        return step[N - 1];
    }
}