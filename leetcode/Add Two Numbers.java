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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = new ListNode(0);
        ListNode cursor = head;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int val = temp;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            cursor.next = new ListNode(val % 10);
            temp = val / 10;
            cursor = cursor.next;
        }
        if (temp > 0)
            cursor.next = new ListNode(temp);
        return head.next;
    }
}