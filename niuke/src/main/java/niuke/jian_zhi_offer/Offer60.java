package niuke.jian_zhi_offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CheNbXxx
 * @description 逐行遍历二叉树
 * @email chenbxxx@gmail.con
 * @date 2019/2/18 10:48
 */
public class Offer60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        Map<Integer, ArrayList<Integer>> res = new HashMap<>();

        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            handle(pRoot, 0);
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                final ArrayList<Integer> list = res.get(i);
                result.add(list);
            }
            return result;
        }

        private void handle(TreeNode root, int p) {
            if (root == null) {
                return;
            }
            ArrayList<Integer> integers = res.get(p);
            if (integers == null) {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(root.val);
                res.put(p, objects);
            } else {
                integers.add(root.val);
            }
            handle(root.left, ++p);
            handle(root.right, p);
        }
    }
}
