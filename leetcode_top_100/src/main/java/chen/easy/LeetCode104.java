package chen.easy;

/**
 * @author CheNbXxx
 * @description 树的深度
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 11:32
 */
public class LeetCode104 {
	/** Definition for a binary tree node.*/
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	class Solution {
		public int maxDepth(TreeNode root) {
			return deepSearch(root,0);
		}

		private int deepSearch(TreeNode node,int deep){
			if(node == null){
				return deep;
			}
			return Math.max(deepSearch(node.left,++deep),deepSearch(node.right,deep));
		}
	}
}
