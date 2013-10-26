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
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = new ListNode(0);
        ListNode cursor = newHead;
        newHead.next = head;

        while (cursor.next != null && cursor.next.next != null) {
            ListNode buffer = cursor.next;
            cursor.next = cursor.next.next;
            buffer.next = buffer.next.next;
            cursor.next.next = buffer;
            cursor = buffer;
        }
        return newHead.next;
    }
}