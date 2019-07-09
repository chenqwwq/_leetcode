package chen.easy;

/**
 * @author CheNbXxx
 * @description 反转二叉树，递归左右子树
 * @email chenbxxx@gmail.con
 * @date 2019/2/21 13:56
 */
public class LeetCode226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
                invertTree(root.left);
                invertTree(root.right);
            }
            return root;
        }
    }
}
