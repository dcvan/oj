/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode buffer = root;
        while (root != null) {
            if (root.left == null)
                return;
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
            root = root.next;
        }

        if (buffer.left != null)
            connect(buffer.left);
    }
}