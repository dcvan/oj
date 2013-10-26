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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return list;

        int height = visit(root);
        for (int i = 0; i < height; i++)
            list.add(new ArrayList<Integer>());

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
            ArrayList<Integer> newList = new ArrayList<Integer>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                newList.add(node.val);

                if (node.left != null)
                    nextQueue.offer(node.left);
                if (node.right != null)
                    nextQueue.offer(node.right);
            }
            queue.addAll(nextQueue);
            list.set(--height, newList);
        }
        return list;
    }

    public int visit(TreeNode node) {
        if (node == null)
            return 0;
        int left_h = visit(node.left);
        int right_h = visit(node.right);
        return Math.max(left_h + 1, right_h + 1);
    }
}