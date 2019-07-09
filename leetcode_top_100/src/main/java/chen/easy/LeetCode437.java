package chen.easy;

/**
 * @author chen
 * @description 求二叉树路径上的值等于n的路径个数
 * 1. 深度优先遍历 递归处理
 * 2. 发现忽略的条件: The path does not need to start or end at the root or a leaf
 * 3. 作为中间节点和头节点在一个方法内递归会导致节点被重复选择为头节点,将两个递归隔离开
 * @email chenbxxx@gmail.com
 * @date 19-2-23
 */
public class LeetCode437 {
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	class Solution {
		private int res = 0;
		public int pathSum(TreeNode root, int sum) {
			getSum(root,0,sum);
			if(root != null) {
				pathSum(root.left, sum);
				pathSum(root.right, sum);
			}
			return res;
		}

		public void getSum(TreeNode root, int currSum, int sum){
			if(root == null){
				return;
			}
			currSum += root.val;
			if(currSum == sum){
				res++;
			}
			// 作为中间节点
			getSum(root.left,currSum,sum);
			getSum(root.right,currSum,sum);
		}
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.right = node2;
		node2.right = node3;
		node3.right = node4;
		node4.right = node5;

		System.out.println(new LeetCode437().new Solution().pathSum(node1,3));
	}
}
