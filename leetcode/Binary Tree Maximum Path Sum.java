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

	int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        visit(root);
        return max;
    }

    public int visit(TreeNode node){
    	if (node == null)
    		return 0;

		int left  = visit(node.left);
		int right = visit(node.right);

		int innerMax = Integer.MIN_VALUE;
		innerMax = Math.max(innerMax, node.val);
		innerMax = Math.max(innerMax, left + node.val);
		innerMax = Math.max(innerMax, right + node.val);

		max = Math.max(max, innerMax);
		max = Math.max(max, left + right + node.val);
		return innerMax;
    }
}