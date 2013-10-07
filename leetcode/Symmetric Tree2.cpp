/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <queue>
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // recursive version
        if (root == NULL) return true;
        return recur(root->left, root->right);
    }
    
    bool recur(TreeNode *ln, TreeNode *rn) {
        if (ln == NULL && rn == NULL) return true;
        else if (ln == NULL || rn == NULL) return false;
        else if (ln->val != rn->val) return false;
        else {
            return recur(ln->left, rn->right) && recur(ln->right, rn->left);
        }
    }
};
