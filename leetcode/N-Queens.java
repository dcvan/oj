public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        list = new ArrayList<String[]>();
        if (n == 0)
            return list;

        N = n;
        num = new int[N][N];
        srow = new int[N];
        scol = new int[N];
        sd1 = new int[2 * N];
        sd2 = new int[2 * N];
        fill(0);
        return list;
    }

    int N;
    ArrayList<String[]> list;
    int[][] num;
    int[] srow;
    int[] scol;
    int[] sd1;
    int[] sd2;

    public void fill(int row) {
        if (row == N) {
            String[] strs = new String[N];
            for (int i = 0; i < N; i++) {
                strs[i] = "";
                for (int j = 0; j < N; j++)
                    strs[i] = (num[i][j] == 1) ? strs[i] + "Q" : strs[i] + ".";

            }
            list.add(strs);
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