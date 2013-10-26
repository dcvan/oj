/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;

        ListNode cursor_1 = head;
        ListNode cursor_2 = head;
        int k = 0;
        while (cursor_1.next != null) {
            cursor_1 = cursor_1.next;
            k++;
            if (k > n) {
                cursor_2 = cursor_2.next;
            }
        }
        if (k < n - 1)
            return head;
        if (k == n - 1)
            return head.next;
        if (n == 1)
            cursor_2.next = null;
        else
            cursor_2.next = cursor_2.next.next;
        return head;
    }
}