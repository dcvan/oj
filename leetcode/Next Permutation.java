public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1)
            return;

        int N = num.length;
        int cursor = N - 1;
        while (cursor > 0) {
            if (num[cursor] > num[cursor - 1])
                break;
            cursor --;
        }

        if (cursor == 0) {
            reverse(num, 0, N - 1);
            return;
        }

        for (int i = N - 1; i >= 0; i--) {
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