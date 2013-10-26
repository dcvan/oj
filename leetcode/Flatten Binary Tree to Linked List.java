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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        lastNode = root;
        visit(root);
    }

    TreeNode lastNode;
    public void visit(TreeNode node) {
    	TreeNode rightNode = node.right;
    	if (node.left != null) {
			lastNode.right = node.left;
			lastNode.left = null;
			lastNode = lastNode.right;
			visit(lastNode);
		}
    	if (rightNode != null) {
			lastNode.right = rightNode;
			lastNode.left = null;
			lastNode = lastNode.right;
			visit(lastNode);
		}
    }
}