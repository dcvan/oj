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
    
    void chooseBinInsert(vector<int> &num, int start, int end, TreeNode *nd) {
        if (start > end || nd == NULL) return;
        
        int mid = (end-start)/2 + start;
        TreeNode *nnd = new TreeNode(num[mid]);
        
        if (nd->val > num[mid])
            nd->left = nnd;
        else
            nd->right = nnd;
            
        chooseBinInsert(num, start, mid-1, nnd);
        chooseBinInsert(num, mid+1, end, nnd);
    }
    
    TreeNode *sortedArrayToBST(vector<int> &num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num.empty()) return NULL;
        
        int len = num.size();
        int mid = (len-1)/2;
        TreeNode *root = new TreeNode(num[mid]);
        chooseBinInsert(num, 0, mid-1, root);
        chooseBinInsert(num, mid+1, len-1, root);
        
        return root;
    }
};
