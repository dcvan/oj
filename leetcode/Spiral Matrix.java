public class Solution {
    ArrayList<Integer> list;
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        f(0, 0, matrix[0].length, matrix.length, matrix);
        return list;
    }

    public void f(int x, int y, int w, int h, int[][] matrix) {
        if (w == 0 || h == 0)
            return;

        if (w == 1) {
            for (int i = y; i < y + h; i++)
                list.add(matrix[x][i]);
            return;
        }
        if (h == 1) {
            for (int i = x; i < x + w; i++)
                list.add(matrix[i][y]);
            return;
        }
        for (int i = x; i < x + w - 1; i++)
            list.add(matrix[y][i]);
        for (int i = y; i < y + h - 1; i++)
            list.add(matrix[i][x + w - 1]);
        for (int i = x + w - 1; i > x; i--)
            list.add(matrix[y + h - 1][i]);
        for (int i = y + h - 1; i > y; i--)
            list.add(matrix[i][x]);
        f(x + 1, y + 1, w - 2, h - 2, matrix);
    }
}