package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 二叉树对称判断
 * 1. 第一感觉用递归
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer58 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public class Solution {
        boolean isSymmetrical(TreeNode pRoot) {
            if (pRoot == null) {
                return true;
            }
            return handle(pRoot.left, pRoot.right);
        }

        private boolean handle(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            return handle(node1.left, node2.right) && handle(node1.right, node2.left);
        }
    }
}
