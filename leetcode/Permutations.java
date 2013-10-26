class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return list;
        int N = num.length;
        int K = 1;
        for (int i = 1; i <= N; i++)
            K *= i;
        while (K >= 1) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (int i = 0; i < N; i++)
                newList.add(num[i]);

            list.add(newList);
            next(num);
            K --;
        }
        return list;
    }

    public void next(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        int N = num.length;
        int cursor = N - 1;
        while (cursor > 0) {
            if (num[cursor] > num[cursor - 1])
                break;
            cursor --;
        }

        if (cursor == 0){
            reverse(num, 0, N - 1);
            return;
        }
        for (int i = N - 1; i >= 1; i--) {
            if (num[i] > num[cursor - 1]) {
                num[i] = num[cursor - 1] - num[i];
                num[cursor - 1] -= num[i];
                num[i] += num[cursor - 1];
                break;
            }
        }
        reverse(num, cursor, N - 1);
    }

    public void reverse(int[] num, int start, int end) {
        for (int i = start; i < (start + end + 1) / 2; i++) {
            num[i] = num[start + end - i] - num[i];
            num[start + end - i] -= num[i];
            num[i] += num[start + end - i];
        }
    }
}