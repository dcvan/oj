public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int N = triangle.size();
        if (N == 0)
            return 0;

        int num[] = new int[N + 1];
        for (int row = N - 1; row >= 0; row--) {
            ArrayList<Integer> list = triangle.get(row);
            for (int col = 0; col <= row; col++)
                num[col] = Math.min(list.get(col) + num[col], list.get(col) + num[col + 1]);
        }
        return num[0];
    }
}