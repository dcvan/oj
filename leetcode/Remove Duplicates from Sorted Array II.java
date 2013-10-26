public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int prev = A[0];
        int count = 1;
        int cursor = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == prev) {
                count++;
                if (count <= 2) {
                    A[cursor] = A[i];
                    cursor++;
                }
            } else {
                prev = A[i];
                count = 1;
                A[cursor] = A[i];
                cursor++;
            }
        }
        return cursor;
    }
}