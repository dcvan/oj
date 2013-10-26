public class Solution {
    public String multiply(String num1, String num2) {
    	if (num1.equals("0") || num2.equals("0"))
    		return "0";

        int M = num1.length();
        int N = num2.length();

        String result = "";
        String string = "";
        for (int i = 0; i < N; i++) {
            if (i > 0)
                string += "0";
            result = add(result, multi(num1 + string, Integer.parseInt(num2.substring(N - 1 - i, N - i))));
        }
        while (result.charAt(0) == '0') {
            if (result.length() == 1)
                break;
            result = result.substring(1);
        }

        return result;
    }

    public String multi(String a, int n) {
        if (n == 0)
            return "0";

        int buffer = 0;
        String result = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            int A = Integer.parseInt(a.substring(i, i + 1)) * n;
            result = (A + buffer) % 10 + result;
            buffer = (A + buffer) / 10;
        }
        if (buffer != 0)
            result = buffer + result;
        return result;
    }

    public String add(String a, String b) {
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;

        int buffer = 0;
        int k = 1;
        String result = "";
        while (true) {
            if (k > a.length() && k > b.length())
                break;
            int A = (k <= a.length()) ? Integer.parseInt(a.substring(a.length() - k, a.length() - k + 1)) : 0;
            int B = (k <= b.length()) ? Integer.parseInt(b.substring(b.length() - k, b.length() - k + 1)) : 0;
            result = (A + B + buffer) % 10 + result;
            buffer = (A + B + buffer) / 10;
            k++;
        }
        if (buffer > 0)
            result = buffer + result;
        return result;
    }
}