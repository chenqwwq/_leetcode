package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 二叉搜索树的第K个节点, 递归解决
 * @email chenbxxx@gmail.con
 * @date 2019/2/18 14:29
 */
public class Offer62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        private TreeNode kNode;
        private int count = 0;

        TreeNode KthNode(TreeNode pRoot, int k) {
            handle(pRoot, k);
            return kNode;
        }

        private void handle(TreeNode node, int k) {
            if (node == null) {
                return;
            }
            // 让右子树先加
            handle(node.left, k);
            if (++count == k) {
                kNode = node;
            }
            handle(node.right, k);
        }

    }
}
