/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSameTree(TreeNode *p, TreeNode *q) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (p == NULL && q == NULL) return true;
        if ((p == NULL && q != NULL) || (p != NULL && q == NULL)) return false;

        // same value
        if (p->val != q->val) return false;

        // same structure
        if (p->left == NULL && q->left != NULL) return false;
        if (q->left == NULL && p->left != NULL) return false;
        if (p->right == NULL && q->right != NULL) return false;
        if (q->right == NULL && p->right != NULL) return false;

        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
};
