package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 求二叉树的深度
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 17:31
 */
public class Offer38 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public int TreeDepth(TreeNode root) {
            return traversing(root, 1);
        }

        public int traversing(TreeNode node, int i) {
            if (node == null) {
                return i;
            }
            if (node.left == null && node.right == null) {
                return ++i;
            }
            return Math.max(traversing(node.left, ++i), traversing(node.right, i));
        }
    }
}
