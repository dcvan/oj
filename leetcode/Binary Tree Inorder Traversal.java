/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cursor = root;
        while (cursor != null || !stack.isEmpty()){
        	if (cursor != null){
        		stack.push(cursor);
        		cursor = cursor.left;
        		continue;
        	}
        	cursor = stack.pop();
        	list.add(cursor.val);
        	cursor = cursor.right;
        }
        return list;
    }
}