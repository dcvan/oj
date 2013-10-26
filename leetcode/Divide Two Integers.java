public class Solution {
    public int divide(int dividend, int divisor) {
        long d1 = (long) dividend;
        long d2 = (long) divisor;

        d1 = Math.abs(d1);
        d2 = Math.abs(d2);

        int type = 1;
        type = (dividend > 0) ? type : -type;
        type = (divisor  > 0) ? type : -type;

        long num[] = new long[32];
        num[0] = d2;
        for (int i = 1; i < 32; i++) {
            num[i] = num[i - 1] + num[i - 1];
        }

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if (d1 >= num[i]) {
                d1 -= num[i];
                result += (1 << i);
            }
        }
        result = (type < 0) ? -result : result;
        return result;
    }
}