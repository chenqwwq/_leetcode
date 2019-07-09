package chen.easy;

/**
 * @author chen
 * @description  判断t是否是s的子树
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode572 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	class Solution {
		public boolean isSubtree(TreeNode s, TreeNode t) {
			if(t == null || s == null){
				return false;
			}
			if(s.val == t.val){
				if(check(s,t)){
					return true;
				}
			}
			return isSubtree(s.right,t) || isSubtree(s.left,t);
		}

		private boolean check(TreeNode src,TreeNode des){
			if(src == null && des == null){
				return true;
			}
			if (src == null || des == null || src.val != des.val){
				return false;
			}
			return check(src.right,des.right) && check(src.left,des.right);
		}
	}
}
