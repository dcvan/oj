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

        TreeLinkNode buffer = null;
        TreeLinkNode childCursor = null;
        while (root != null) {
            if (childCursor == null) {
                if (root.left != null || root.right != null) {
                    childCursor = (root.left != null) ? root.left : root.right;
                    buffer = childCursor;
                }
                if (root.left != null && root.right != null) {
                    childCursor.next = root.right;
                    childCursor = childCursor.next;
                }
            } else {
                if (root.left != null) {
                    childCursor.next = root.left;
                    childCursor = childCursor.next;
                }
                if (root.right != null) {
                    childCursor.next = root.right;
                    childCursor = childCursor.next;
                }
            }
            root = root.next;
        }
        connect(buffer);
    }
}