package niuke.jian_zhi_offer;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author CheNbXxx
 * @description 二叉树种和为某一值的路径，第一感觉类似于深度优先遍历
 * @email chenbxxx@gmail.con
 * @date 2019/2/13 10:07
 */
public class Offer24 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            listAndAdd(new ArrayList<>(), root, 0, target);
            Collections.reverse(res);
            return res;
        }

        private void listAndAdd(ArrayList<Integer> des, TreeNode node, int curr, int target) {
            // 遍历
            if (node == null) {
                return;
            }
            des.add(node.val);
            final int total = curr + node.val;
            // 当前节点为叶子节点时判断
            if (node.right == null && node.left == null) {
                if (total == target) {
                    res.add(des);
                }
                return;
            }
            if (total > target) {
                return;
            }
            listAndAdd(new ArrayList<>(des), node.right, total, target);
            listAndAdd(new ArrayList<>(des), node.left, total, target);
        }
    }
}
