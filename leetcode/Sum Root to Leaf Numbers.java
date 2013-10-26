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
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		ArrayList<String> list = visit(root);
		int sum = 0;
		for (String str:list)
			sum += Integer.parseInt(str);
		
		return sum;
	}

	public ArrayList<String> visit(TreeNode node) {
		ArrayList<String> result = new ArrayList<String>();
		if (node.left == null && node.right == null){
			result.add(node.val + "");
			return result;
		}

		if (node.left != null) {
			ArrayList<String> left = visit(node.left);
			for (String str : left)
				result.add(node.val + str);
		}
		if (node.right != null) {
			ArrayList<String> right = visit(node.right);
			for (String str : right)
				result.add(node.val + str);
		}
		return result;
	}
}