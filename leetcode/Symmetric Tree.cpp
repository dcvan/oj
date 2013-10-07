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
        // iterate version
        if (root == NULL) return true;
        
        std::queue<TreeNode *>leftQ, rightQ;
        leftQ.push(root->left);
        rightQ.push(root->right);
        
        while (!leftQ.empty() && !rightQ.empty()) {
            TreeNode *ln = leftQ.front();
            TreeNode *rn = rightQ.front();
            leftQ.pop(); rightQ.pop();
            if (ln == NULL && rn == NULL) continue;
            else if (ln == NULL || rn == NULL) return false;
            else if (ln->val != rn->val) return false;
            else {
                leftQ.push(ln->left); leftQ.push(ln->right);
                rightQ.push(rn->right); rightQ.push(rn->left);
            }
        }
        if (leftQ.empty() && rightQ.empty()) return true;
        else return false;
    }
};
