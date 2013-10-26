public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int pa = m - 1;
        int pb = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if (pb == -1 || (pa >= 0 && pb >= 0 && A[pa] > B[pb]))
                A[i] = A[pa--];
            else
                A[i] = B[pb--];
        }
    }
}