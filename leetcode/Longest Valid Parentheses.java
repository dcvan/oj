public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int maxLen = 0;
        Stack<Node> stack = new Stack<Node>();
        stack.add(new Node("", 0));
        for (int i = 0; i < s.length(); i++) {
            String type = s.substring(i, i + 1);
            if (type.equals("(")) {
                stack.push(new Node("(", i + 1));
                continue;
            } else {
                Node top = stack.peek();
                if (top.type.equals("(")) {
                    stack.pop();
                    maxLen = Math.max(maxLen, i + 1 - stack.peek().index);
                } else {
                    stack.push(new Node(")", i + 1));
                }
            }
        }
        return maxLen;
    }
}

class Node {
    String type;
    int index;
    public Node(String type, int index) {
        this.type = type;
        this.index = index;
    }
}