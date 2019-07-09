package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 树的镜像, 优先采用递归的方式2
 * @email chenbxxx@gmail.com
 * @date 19-2-9
 */
public class Offer18 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public void Mirror(TreeNode root) {
            handle(root);
        }

        public void handle(TreeNode node) {
            if (node == null) {
                return;
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            handle(node.left);
            handle(node.right);
        }
    }
}
