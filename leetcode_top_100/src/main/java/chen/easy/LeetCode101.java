package chen.easy;

/**
 * @author chen
 * @description 检查二叉树是否为镜像
 * 类似如下所示二叉树
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 * @email chenbxxx@gmail.com
 * @date 19-2-23
 */
public class LeetCode101 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	class Solution {
		public boolean isSymmetric(TreeNode root) {
			if(root == null){
				return true;
			}
			return check(root.left,root.right);
		}

		private boolean check(TreeNode leftNode,TreeNode rightNode){
			if (leftNode == null && rightNode == null){
				return true;
			}
			if (leftNode == null || rightNode == null || (leftNode.val != rightNode.val)){
				return false;
			}
			return check(leftNode.left,rightNode.right) && check(rightNode.left,leftNode.right);
		}
	}
}
