/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return visit(1, n);
    }

    public ArrayList<TreeNode> visit(int low, int high) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        if (low > high) {
            list.add(null);
            return list;
        }
        for (int i = low; i <= high; i++) {
            ArrayList<TreeNode> list_left  = visit(low, i - 1);
            ArrayList<TreeNode> list_right = visit(i + 1, high);

            for (TreeNode node_left : list_left) {
                for (TreeNode node_right : list_right) {
                    TreeNode node = new TreeNode(i);
                    node.left  = node_left;
                    node.right = node_right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}