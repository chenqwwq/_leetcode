package top.chenqwwq.leetcode.common;

public class TreeNode {

    public static final TreeNode DEFAULT = new TreeNode(-1);

    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }
}
