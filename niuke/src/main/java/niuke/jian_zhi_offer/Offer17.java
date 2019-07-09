package niuke.jian_zhi_offer;


/**
 * @author chen
 * @description 查找树的子结构
 * @email chenbxxx@gmail.com
 * @date 19-2-9
 */
public class Offer17 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) {
                return false;
            }
            boolean res = false;
            // 判断树的根节点是否一致
            //   不一致则检查左右节点
            //   一致则调用findTree检查后续节点
            if (root1.val == root2.val) {
                res = findTree(root1, root2);
            }

            return res || (HasSubtree(root1.right, root2) || HasSubtree(root1.left, root2));
        }

        private boolean findTree(TreeNode srcTree, TreeNode desTree) {
            if (desTree == null) {
                return true;
            }
            if (srcTree == null) {
                return false;
            }
            if (srcTree.val == desTree.val) {
                return findTree(srcTree.left, desTree.left) && findTree(srcTree.right, desTree.right);
            }
            return false;
        }
    }
}
