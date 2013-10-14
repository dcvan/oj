/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        TreeLinkNode *level = root;
        while (level != NULL) {
            TreeLinkNode *cur = level;
            while (cur != NULL) {
                if (cur->left != NULL) cur->left->next = cur->right;
                if (cur->next != NULL && cur->right != NULL) cur->right->next = cur->next->left;
                cur = cur->next;
            }
            level = level->left;
        }
    }
};
