package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 二叉树中序遍历的下一个节点
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer57 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null) {
                return null;
            }
            /**
             * 节点规律
             * 1. 如果存在右子树,则下个节点就是右子树的最左节点
             * 2. 如果没有则判断父节点和关系
             *      1). 节点为父节点的左子节点,父节点即为下一个节点
             *      2). 节点为父节点的右子节点,一直往上遍历找到存在右节点的上层节点,该节点就是
             */
            if (pNode.right != null) {
                return getMostLeft(pNode.right);
            }
            TreeLinkNode pParent = pNode.next;

            if (pParent == null) {
                return null;
            }
            if (pParent.left == pNode) {
                return pParent;
            }
            if (pParent.right == pNode) {
                return getNodeRight(pNode);
            }
            return null;
        }

        /**
         * 往上遍历找到第一个右节点不为空的节点
         */
        private TreeLinkNode getNodeRight(TreeLinkNode node) {
            if (node.next == null) {
                return null;
            }
            if (node.next.left == node) {
                return node.next;
            }
            return getNodeRight(node.next);
        }

        /**
         * 找到某个节点下的最左节点
         */
        private TreeLinkNode getMostLeft(TreeLinkNode node) {
            if (node.left == null) {
                return node;
            }
            return getMostLeft(node.left);
        }
    }
}
