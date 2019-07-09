package chen.medium;

/**
 * 114. 二叉树原地展开为链表
 *
 * @author chen
 * @date 19-4-21
 */
public class LeetCode114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public void flatten(TreeNode root) {
            dfs(root);
        }

        public TreeNode dfs(TreeNode root){
            if(root == null){
                return root;
            }
            TreeNode res = root,rightNode = dfs(root.right);
            root.right = dfs(root.left);
            root.left = null;
            // 遍历到底部
            while (root.right != null){
                root = root.right;
            }
            root.right = rightNode;
            return res;
        }
    }
}
