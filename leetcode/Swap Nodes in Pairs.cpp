/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode *pre = NULL;  // pointer to the pointer pointing to the swapping part.
        ListNode *walker = head;
        while (walker != NULL && walker->next != NULL) {
            if (walker == head) head = walker->next;
            if (pre != NULL)
                pre->next = walker->next;
            pre = walker;
            ListNode *post = walker->next->next;
            walker->next->next = walker;
            walker->next = post;
            walker = post;
        }
        return head;
    }
};
