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
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null)
    		return null;

    	ListNode cursor = head;
    	while (cursor.next != null){
    		if (cursor.next.val != cursor.val)
    			cursor = cursor.next;
    		else
    			cursor.next = cursor.next.next;
    	}
    	return head;
    }
}