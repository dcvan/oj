public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "";
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0)
                continue;
            if (strs[i].equals("."))
                continue;
            if (strs[i].equals("..")) {
                if (stack.size() > 0)
                    stack.pop();
                continue;
            }
            stack.add(strs[i]);
        }
        String result = "/";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        if (! result.equals("/"))
            result = result.substring(0, result.length() - 1);
        return result;
    }
}