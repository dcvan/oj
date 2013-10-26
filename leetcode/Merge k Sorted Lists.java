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
import java.util.*;
public class Solution {

    PriorityQueue<ListNode> minQueue = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
        public int compare(ListNode node1, ListNode node2) {
            if (node1.val > node2.val)
                return 1;
            return -1;
        }
    });

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null)
            return null;
        minQueue.clear();
 		for (ListNode node:lists)
 		    if (node != null)
     			minQueue.add(node);
 		
 		ListNode head = new ListNode(0);
 		ListNode cursor = head;
 		while (!minQueue.isEmpty()){
 			ListNode minNode = minQueue.poll();
 			cursor.next = minNode;
 			cursor = cursor.next;
 			if (minNode.next != null)
 				minQueue.add(minNode.next);
 		}
 		return head.next;
    }
}