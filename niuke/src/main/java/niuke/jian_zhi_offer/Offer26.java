package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 二叉搜索树和双向链表
 * @email chenbxxx@gmail.com
 * @date 19-2-13
 */
public class Offer26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {

        public TreeNode Convert(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode head = null;
            if (root.left != null) {
                TreeNode h = Convert(root.left);
                head = h;
                while (h.right != null) {
                    h = h.right;
                }
                h.right = root;
                root.left = h;
            }

            if (root.right != null) {
                TreeNode h = Convert(root.right);
                root.right = h;
                h.left = root;
            }

            return head != null ? head : root;
        }
    }
}
