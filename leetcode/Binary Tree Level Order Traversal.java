import java.util.*;
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
            ArrayList<Integer> newList = new ArrayList<Integer>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                newList.add(node.val);

                if (node.left != null)
                    nextQueue.offer(node.left);
                if (node.right != null)
                    nextQueue.offer(node.right);
            }
            list.add(newList);
            queue.addAll(nextQueue);
            nextQueue = new LinkedList<TreeNode>();
        }
        return list;
    }
}