package top.chenbxxx.by_topics.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author chen
 * @date 2019/11/25 上午8:27
 */
public class $103_BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        /**
         * 以双端队列作为辅助
         * 将子节点全部入队列,且逐个遍历
         */
        LinkedList<TreeNode> nodes = new LinkedList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return res;
            }

            nodes.add(root);

            while (nodes.size() > 0) {

            }

            return null;
        }


        private void bfs(LinkedList<TreeNode> nodes, int depth) {
            if (nodes == null) {
                return;
            }

            while (nodes.size() < depth) {
                res.add(new ArrayList<>());
            }

            // 根据奇偶判断是否从左往右
            if ((depth & 1) == 1) {
                while (nodes.size() > 0) {
                    final TreeNode first = nodes.getFirst();
//                    res.get(depth).add(first.);
                }
            }
        }

    }
}
