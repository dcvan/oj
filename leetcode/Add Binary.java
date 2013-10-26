public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null)
            return "";

        int buffer = 0;
        int cursor = 0;
        String result = "";
        while (true) {
            int A = 0; int B = 0;
            if (cursor >= Math.max(a.length(), b.length()))
                break;
            if (cursor < a.length())
                A = Integer.parseInt(a.substring(a.length() - cursor - 1, a.length() - cursor));
            if (cursor < b.length())
                B = Integer.parseInt(b.substring(b.length() - cursor - 1, b.length() - cursor));
            result = (A + B + buffer) % 2 + result;
            buffer = (A + B + buffer) / 2;
            cursor ++;
        }
        if (buffer > 0)
            result = 1 + result;
        return result;
    }
}