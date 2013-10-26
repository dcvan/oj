public class Solution {
    public String countAndSay(int n) {
        String string = "1";
        if (n == 1)
            return string;
        for (int i = 2; i <= n; i++) {
            String newStr = "";
            char buffer = string.charAt(0);
            int count = 1;
            for (int j = 1; j < string.length(); j++) {
                if (string.charAt(j) == buffer)
                    count++;
                else {
                    newStr = newStr + "" + count + "" + buffer;
                    buffer = string.charAt(j);
                    count = 1;
                }
            }
            newStr = newStr + "" + count + "" + buffer;
            string = newStr;
        }
        return string;
    }
}