public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] num = { -1, -1};
        if (A == null || A.length == 0)
            return num;

        int N = A.length;
        int x = 0;
        int y = N - 1;
        // left:
        while (x < y) {
            if (x == y - 1) {
                if (A[x] != target)
                    x = y;
                break;
            }
            int mid = (x + y) / 2;
            if (A[mid] < target)
                x = mid;
            if (A[mid] >= target)
                y = mid;
        }
        if (A[x] != target)
            return num;
        num[0] = x;

        // right:
        x = 0;
        y = N - 1;
        while (x < y) {
            if (x == y - 1) {
                if (A[y] != target)
                    y = x;
                break;
            }
            int mid = (x + y) / 2;
            if (A[mid] <= target)
                x = mid;
            if (A[mid] > target)
                y = mid;
        }
        num[1] = y;
        return num;
    }
}