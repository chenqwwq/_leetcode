package niuke.jian_zhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chen
 * @description 二叉树的广度优先遍历
 * @email chenbxxx@gmail.com
 * @date 19-2-12
 */
public class Offer22 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        /**
         * 结果
         */
        private ArrayList<Integer> res = new ArrayList<>();

        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            addChildNodeByBFS(root);
            return res;
        }

        private void addChildNodeByDFS(TreeNode node) {
            if (node == null) {
                return;
            }
            res.add(node.val);
            addChildNodeByDFS(node.right);
            addChildNodeByDFS(node.left);
        }

        private void addChildNodeByBFS(TreeNode node) {
            if (node == null) {
                return;
            }
            /**
             * 使用队列来完成此轮操作
             *     首先父节点入队列,父节点处理完出队列之后左右节点入队列,while循环处理
             */
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            // 根节点入队列
            // 队列时FILO 栈时FIFO
            treeNodeQueue.offer(node);

            while (!treeNodeQueue.isEmpty()) {
                final TreeNode poll = treeNodeQueue.poll();
                res.add(poll.val);
                // 题目中要求时同层节点从左到右
                if (poll.left != null) {
                    treeNodeQueue.offer(poll.left);
                }
                if (poll.right != null) {
                    treeNodeQueue.offer(poll.right);
                }
            }
        }
    }
}
