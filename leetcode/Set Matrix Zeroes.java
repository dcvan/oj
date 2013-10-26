public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int M = matrix.length;
        int N = matrix[0].length;
        // mark the 0th row and 0th col:
        int flag[] = new int[2];

        for (int i = 0; i < M; i++)
            if (matrix[i][0] == 0)
                flag[0] = 1;
        for (int i = 0; i < N; i++)
            if (matrix[0][i] == 0)
                flag[1] = 1;
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            if (matrix[0][i] == 0)
                for (int j = 0; j < M; j++)
                    matrix[j][i] = 0;
        }
        for (int i = 1; i < M; i++) {
            if (matrix[i][0] == 0)
                for (int j = 0; j < N; j++)
                    matrix[i][j] = 0;
        }
        if (flag[0] == 1) {
            for (int i = 0; i < M; i++)
                matrix[i][0] = 0;
        }
        if (flag[1] == 1) {
            for (int i = 0; i < N; i++)
                matrix[0][i] = 0;
        }
    }
}