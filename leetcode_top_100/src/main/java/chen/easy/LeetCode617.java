package chen.easy;

/**
 * @author CheNbXxx
 * @description 合并两颗二叉树
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 10:56
 */
public class LeetCode617 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            return merge(t1, t2);
        }

        private TreeNode merge(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            TreeNode root = new TreeNode((t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0));

            root.left = merge(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            root.right = merge(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

            return root;
        }
    }
}
