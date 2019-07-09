package niuke.jian_zhi_offer;


/**
 * @author CheNbXxx
 * @description 序列化和反序列化二叉树
 * 1. 以中序遍历序列化二叉树
 * @email chenbxxx@gmail.con
 * @date 2019/2/18 11:20
 */
public class Offer61 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;

        final Solution solution = new Offer61().new Solution();
        final String serialize = solution.Serialize(root);
        System.out.println(serialize);
        final TreeNode deserialize = solution.Deserialize(serialize);
        System.out.println(deserialize.val);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        String Serialize(TreeNode root) {
            if (root == null) {
                return "#";
            }
            // 以前序和中序序列化一个二叉树
            return preSearch(root, "") + "#" + midSearch(root, "");
        }

        TreeNode Deserialize(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            // 将字符串拆分成先序和中序遍历的
            final String[] split = str.split("#");
            if (split.length != 2) {
                return null;
            }
            // 接下来就是从先序和中序遍历恢复二叉树
            return restoreTree(split[0], split[1]);
        }

        private String preSearch(TreeNode root, String res) {
            if (root == null) {
                return res;
            }
            return preSearch(root.right, preSearch(root.left, res + root.val));
        }

        private String midSearch(TreeNode root, String res) {
            if (root == null) {
                return res;
            }
            return midSearch(root.right, midSearch(root, "") + root.val);
        }

        private TreeNode restoreTree(String pre, String mid) {
            return buildTree(string2IntArray(pre), string2IntArray(mid), 0, 0, mid.length() - 1);
        }

        private TreeNode buildTree(int[] pre, int[] mid, int preIndex, int midStart, int midEnd) {
            if (preIndex > pre.length - 1 || midStart > midEnd) {
                return null;
            }
            // 构建当前节点
            TreeNode root = new TreeNode(pre[preIndex]);
            // 确定root在数组中的位置
            int rootIndexInMid = 0;
            while (pre[preIndex] != mid[rootIndexInMid]) {
                rootIndexInMid++;
            }
            root.left = buildTree(pre, mid, preIndex + 1, midStart, rootIndexInMid - 1);
            root.right = buildTree(pre, mid, preIndex + rootIndexInMid - midStart + 1, rootIndexInMid + 1, midEnd);
            return root;
        }

        private int[] string2IntArray(String str) {
            int[] n = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                n[i] = Integer.parseInt(str.substring(i, i + 1));
            }
            return n;

        }
    }
}
