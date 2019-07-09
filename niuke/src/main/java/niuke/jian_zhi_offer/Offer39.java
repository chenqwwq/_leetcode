package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 判断是否是平衡二叉树
 * 1. 平衡二叉树又称为AVL树,左右两个子树高度差不超过1,且左右两个子树都为AVL树.
 * 2. 空树也算是AVL树
 * 乍一看就是递归了,
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 17:52
 */
public class Offer39 {
    public class Solution {
        public boolean IsBalanced_Solution(TreeNode root) {
            return false;
        }

        public class TreeNode {
            int val = 0;
            Offer38.TreeNode left = null;
            Offer38.TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }
//
    }
}
