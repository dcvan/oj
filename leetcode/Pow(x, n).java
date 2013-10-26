import java.text.*;

public class Solution {
    public double pow(double x, int n) {
        if (x == 0 || x == 1 || (x == -1 && n % 2 == 1))
            return x;
        if (x == -1)
            return -x;

        long N = Math.abs((long)n);
        long num[] = new long[32];
        double buffer = x;
        double result = 1;

        for (int i = 0; i < 32; i++) {
        	if (i > 0)
            	buffer = buffer * buffer;
            num[i] = (N % 2);
            result = (num[i] == 0) ? result : result * buffer;
            N = N / 2;
        }
        if (n < 0)
        	result = 1 / result;
        DecimalFormat formatter = new DecimalFormat("0.00000");
        return Double.parseDouble(formatter.format(result));
    }
}