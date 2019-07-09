package niuke.jian_zhi_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CheNbXxx
 * @description 之字型打印二叉树
 * 1. 第一感觉类似于先遍历
 * @email chenbxxx@gmail.con
 * @date 2019/2/18 10:01
 */
public class Offer59 {
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

        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            handle(pRoot, 0);
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                final ArrayList<Integer> list = res.get(i);
                if (i % 2 == 0) {
                    result.add(list);
                } else {
                    Collections.reverse(list);
                    result.add(list);
                }
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
