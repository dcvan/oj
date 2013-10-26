public class Solution {
    public int totalNQueens(int n) {
        if (n == 0)
            return 0;

        N = n;
        sum = 0;
        num = new int[N][N];
        srow = new int[N];
        scol = new int[N];
        sd1 = new int[2 * N];
        sd2 = new int[2 * N];
        fill(0);
        return sum;
    }

    int N;
    int sum;
    ArrayList<String[]> list;
    int[][] num;
    int[] srow;
    int[] scol;
    int[] sd1;
    int[] sd2;

    public void fill(int row) {
        if (row == N) {
            sum++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (srow[row] == 0 && scol[col] == 0 && sd1[row + col] == 0 && sd2[row - col + N] == 0) {
                num[row][col]  = 1;
                srow[row]      = 1;
                scol[col]      = 1;
                sd1[row + col]     = 1;
                sd2[row - col + N] = 1;
                // fill the next row:
                fill(row + 1);

                num[row][col]  = 0;
                srow[row]      = 0;
                scol[col]      = 0;
                sd1[row + col]     = 0;
                sd2[row - col + N] = 0;
            }
        }
    }
}