public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int N = A.length;
        int B[] = new int[N];
        int C[] = new int[N];
        B[0] = A[0];
        C[N - 1] = A[N - 1];

        for (int i = 1; i < N; i++) {
            B[i] = Math.max(B[i - 1], A[i]);
            C[N - 1 - i] = Math.max(C[N - i], A[N - 1 - i]);
        }
        int sum = 0;
        for (int i = 1; i < N - 1; i++)
            sum += Math.max(Math.min(B[i - 1], C[i + 1]) - A[i], 0);
        
        return sum;
    }
}