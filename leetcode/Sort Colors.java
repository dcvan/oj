public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0)
            return;
        int N = A.length;
        int point = -1;
        int point_1 = -1;
        int point_2 = -1;
        while (point < A.length - 1) {
            point++;
            if (A[point] == 2) {
                if (point_2 == -1)
                    point_2 = point;
            } else if (A[point] == 1) {
                if (point_1 == -1)
                    point_1 = point;
                if (point_2 != -1) {
                    A[point_2] = 1;
                    A[point] = 2;
                    point_2 ++;
                    point_1 = Math.min(point_1, point_2 - 1);
                }
            } else if (A[point] == 0) {
                if (point_1 == -1 && point_2 == -1)
                    continue;
                if (point_1 == -1) {
                    A[point_2] = 0;
                    A[point] = 2;
                    point_2 ++;
                } else {
                    A[point_1] = 0;
                    A[point] = 1;
                    if (point_2 == -1) {
                        point_1 ++;
                        continue;
                    } else {
                        A[point] = 2;
                        A[point_2] = 1;
                        point_1 ++;
                        point_2 ++;
                    }
                }
            }
        }
    }
}