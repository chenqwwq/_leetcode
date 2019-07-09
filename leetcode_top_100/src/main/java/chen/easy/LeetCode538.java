package chen.easy;

/**
 * @author CheNbXxx
 * @description     将二叉树转化为累加树
 * 1. 求和可以采用共享变量
 * @email chenbxxx@gmail.con
 * @date 2019/2/22 10:04
 */
public class LeetCode538 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	class Solution {
		int sum = 0;
		public TreeNode convertBST(TreeNode root) {
			if(root != null){
				// 先处理左边节点是错误的。。。。
				// 因为sum的累加最好从最大的开始
				convertBST(root.right);
				sum+=root.val;
				root.val = sum;
				convertBST(root.left);
			}
			return root;
		}
	}
}
