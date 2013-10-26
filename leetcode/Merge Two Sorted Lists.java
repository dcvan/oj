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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
        	return l2;
        if (l2 == null)
        	return l1;

        ListNode cursor = new ListNode(0);
        ListNode head = cursor;
        while (true){
        	if (l1 == null && l2 == null)
        		break;
        	if (l1 == null){
        		cursor.next = l2;
        		break;
        	}
        	if (l2 == null){
        		cursor.next = l1;
        		break;
        	}

        	if (l1.val <= l2.val){
        		cursor.next = l1;
        		l1 = l1.next;
        	}
        	else{
        		cursor.next = l2;
        		l2 = l2.next;
        	}
        	cursor = cursor.next;
        }
        return head.next;
    }
}