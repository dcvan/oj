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
    public boolean isBalanced(TreeNode root) {
    	BALANCE = true;
        visit(root);

        return BALANCE;
    }

    boolean BALANCE;
    public int visit(TreeNode node){
    	if (node == null)
    		return 0;

    	int left = visit(node.left);
    	int right = visit(node.right);
    	if (Math.abs(left - right) > 1)
    		BALANCE = false;
    	
    	return Math.max(left + 1, right + 1);
    }
}
