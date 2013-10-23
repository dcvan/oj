/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <stack>

class Solution {
public:
    // recursive
    // void step(TreeNode *tn, vector<int>& trace) {
    //     if (tn == NULL) return;
    //     step(tn->left, trace);
    //     trace.push_back(tn->val);
    //     step(tn->right, trace);
    // }
    
    // vector<int> inorderTraversal(TreeNode *root) {
    //     // Note: The Solution object is instantiated only once and is reused by each test case.
    //     vector<int> trace;
    //     step(root, trace);
    //     return trace;
    // }
    
    // bad iterative. Breaking the tree structure !
    // vector<int> inorderTraversal(TreeNode *root) {
    //     // Note: The Solution object is instantiated only once and is reused by each test case.
    //     vector<int> trace;
    //     std::stack<TreeNode *> tns;
    //     if (root != NULL)
    //         tns.push(root);
    //     while (!tns.empty()) {
    //         TreeNode *tn = tns.top();
    //         tns.pop();
    //         if (tn->left != NULL) {
    //             tns.push(tn);
    //             tns.push(tn->left);
    //             tn->left = NULL;
    //             continue;
    //         }
    //         trace.push_back(tn->val);
    //         if (tn->right != NULL)
    //             tns.push(tn->right);
    //     }
        
    //     return trace;
    // }
    
    // better iterative
    vector<int> inorderTraversal(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        vector<int> trace;
        TreeNode *cur = root;
        std::stack<TreeNode *> tns;
        
        while (!tns.empty() || cur) {
            if (cur) {
                tns.push(cur);
                cur = cur->left;
            }
            else {
                cur = tns.top();
                tns.pop();
                trace.push_back(cur->val);
                cur = cur->right;
            }
        }
        
        return trace;
    }
};
