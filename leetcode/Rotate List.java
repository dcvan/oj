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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0)
            return head;

        int len = getLength(head);
        n = n % len;
        if (n == 0)
            return head;

        ListNode cursor_1 = head;
        ListNode cursor_2 = head;
        int k = 0;
        while (cursor_1.next != null) {
            cursor_1 = cursor_1.next;
            k++;
            if (k > n)
                cursor_2 = cursor_2.next;
        }
        ListNode newHead = cursor_2.next;
        cursor_1.next = head;
        cursor_2.next = null;
        return newHead;
    }

    public int getLength(ListNode head){
        if (head == null)
            return 0;
        ListNode cursor = head;
        int length = 0;
        while (cursor != null){
            length ++;
            cursor = cursor.next;
        }
        return length;
    }
}