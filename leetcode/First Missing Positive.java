public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)
            return 1;

        int N = A.length;
        for (int i = 0; i < N; i++) {
            int cursor = A[i];
            while (true) {
                if (cursor <= 0 || cursor >= N + 1 || A[cursor - 1] == cursor)
                    break;
                int next = A[cursor - 1];
                A[cursor - 1] = cursor;
                cursor = next;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i + 1 != A[i])
                return i + 1;
        }
        return N + 1;
    }
}