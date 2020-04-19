package top.chenqwwq.currently.utils;

import top.chenqwwq.currently._common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chen
 * @date 2020/4/18 下午4:52
 */
public class TreeUtils {

    public static TreeNode getTreeByArray(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return TreeNode.DEFAULT;
        }
        if (arr.length == 1) {
            return new TreeNode(arr[0]);
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currIndex = 1;

        while (currIndex < arr.length) {
            final TreeNode pop = queue.poll();
            if (pop == null) {
                throw new RuntimeException("error");
            }
            pop.left = getTreeNode(arr[currIndex++]);

            if (currIndex >= arr.length) {
                break;
            }
            pop.right = getTreeNode(arr[currIndex++]);

            queue.offer(pop.left);
            queue.offer(pop.right);
        }

        return root;
    }

    private static TreeNode getTreeNode(Integer i) {
        return i == null ? null : new TreeNode(i);
    }

}
