public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        // layer by layer:
        int num = 1;
        for (int k = 0; k < (n + 1) / 2; k++) {
            int len = n - 2 * k;
            if (len == 1)
                matrix[k][k] = num++;
            for (int i = 0; i < len - 1; i++)
                matrix[k][k + i] = num++;
            for (int i = 0; i < len - 1; i++)
                matrix[k + i][k + len - 1] = num++;
            for (int i = 0; i < len - 1; i++)
                matrix[k + len - 1][k + len - 1 - i] = num++;
            for (int i = 0; i < len - 1; i++)
                matrix[k + len - 1 - i][k] = num++;
        }
        return matrix;
    }
}