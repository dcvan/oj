/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return list;

        if (root.left == null && root.right == null){
            if (sum == root.val){
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.add(sum);
                list.add(newList);
                return list;                
            }
            return list;
        }

        ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum - root.val);
        ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum - root.val);

        for (ArrayList<Integer> l:left) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.add(root.val);
            newList.addAll(l);
            list.add(newList);
        }
        for (ArrayList<Integer> l:right) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.add(root.val);
            newList.addAll(l);
            list.add(newList);
        }
        return list;
    }
}