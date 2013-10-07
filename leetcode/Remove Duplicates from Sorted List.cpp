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
    ListNode *deleteDuplicates(ListNode *head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode *cur = head;
        while (cur != NULL && cur->next != NULL) {
            if (cur->next->val == cur->val) {
                ListNode *d = cur->next;
                cur->next = cur->next->next;
                delete d;
            }
            else
                cur = cur->next;
        }
        return head;
    }
};
