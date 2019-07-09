package chen.easy;

/**
 * @author CheNbXxx
 * @description 树的最大直径，
 * 1. 第一感觉就是求左右子树最大深度之和
 * 2. 是我太天真。。。如果树单边重是可能不经过根节点的
 * @email chenbxxx@gmail.con
 * @date 2019/2/22 10:33
 */
public class LeetCode543 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}


	class Solution {
		int ans = 1;
		public int diameterOfBinaryTree(TreeNode root) {
			depth(root);
			return ans;
		}

		private int depth(TreeNode node){
	   	    if(node == null){
	   	    	return 0;
	        }
			final int right = depth(node.right);
			final int left = depth(node.left);
			ans = Math.max(ans,right+left+1);
			return Math.max(right,left )+1;
		}
	}
}
