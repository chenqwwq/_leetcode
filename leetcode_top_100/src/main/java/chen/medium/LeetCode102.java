package chen.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @description 二叉树的层级遍历
 * 1. 考虑最简单的递归读取  100%,过
 * @email chenbxxx@gmail.com
 * @date 19-3-4
 */
public class LeetCode102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            handle(root, 0);
            return res;
        }

        private void handle(TreeNode node, int deep) {
            if (node == null) {
                return;
            }
            while (res.size() < deep + 1) {
                res.add(new ArrayList<>());
            }
            // 添加本层元素
            List<Integer> integers = res.get(deep);
            integers.add(node.val);

            // 递归处理
            handle(node.left, ++deep);
            handle(node.right, deep);
        }
    }
}
