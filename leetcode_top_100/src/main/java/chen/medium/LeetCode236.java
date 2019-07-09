package chen.medium;

/**
 * 236. Lowest Common Ancestor of a Binary Tree(LCA)问题
 *
 * @author chen
 * @date 19-5-4
 */
public class LeetCode236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return recursive(root, p, q);
        }

        private TreeNode recursive(TreeNode root, TreeNode l, TreeNode r) {
            // 尝试递归解决
            if (root == null) {
                return null;
            }
            if (root == r || root == l) {
                return root;
            }
            TreeNode left = recursive(root.left, l, r);
            TreeNode right = recursive(root.right, l, r);

            // 递归的关键 如果两边都不为空表示root就是最近父节点
            return left != null && right != null ? root : left != null ? left : right;
        }
    }
}
