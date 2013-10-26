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
    int height = 0;
    public int minDepth(TreeNode root) {
        height = Integer.MAX_VALUE;
        if (root == null)
            return 0;

        visit(root, 1);
        return height;
    }

    public void visit(TreeNode node, int h) {
        if (node.left == null && node.right == null) {
            if (height > h)
                height = h;
            return;
        }
        if (node.left != null)
            visit(node.left, h + 1);
        if (node.right != null)
            visit(node.right, h + 1);
    }
}