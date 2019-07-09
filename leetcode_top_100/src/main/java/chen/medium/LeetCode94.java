package chen.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description  返回二叉树的中序遍历,是对递归的理解。。
 * @email chenbxxx@gmail.con
 * @date 2019/2/26 14:49
 */
public class LeetCode94 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			if(root == null){
				return new LinkedList<>();
			}
			List<Integer> res = inorderTraversal(root.left);
			res.add(root.val);
			res.addAll(inorderTraversal(root.right));
			return res;
		}
	}
}
