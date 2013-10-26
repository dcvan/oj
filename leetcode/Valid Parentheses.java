public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(i, i + 1);
            if (first.equals("(") || first.equals("[") || first.equals("{"))
                stack.push(first);
            if (first.equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("("))
                    return false;
                else
                    stack.pop();
            }
            if (first.equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("["))
                    return false;
                else
                    stack.pop();
            }
            if (first.equals("}")) {
                if (stack.isEmpty() || !stack.peek().equals("{"))
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}