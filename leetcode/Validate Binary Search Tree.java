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
    public boolean isValidBST(TreeNode root) {
        return visit(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean visit(TreeNode node, int low, int high) {
        if (node == null)
            return true;
        if (node.val >= high || node.val <= low)
            return false;
        return visit(node.left, low, node.val) && visit(node.right, node.val, high);
    }
}