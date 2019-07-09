package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description Cyc大佬的解答
 * @email chenbxxx@gmail.con
 * @date 2019/2/18 14:20
 */
public class Offer61_cyc {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        private String deserializeStr;

        public String Serialize(TreeNode root) {
            if (root == null) {
                return "#";
            }
            return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
        }

        public TreeNode Deserialize(String str) {
            deserializeStr = str;
            return Deserialize();
        }

        private TreeNode Deserialize() {
            if (deserializeStr.length() == 0) {
                return null;
            }
            int index = deserializeStr.indexOf(" ");
            String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
            deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
            if (node.equals("#")) {
                return null;
            }
            int val = Integer.valueOf(node);
            TreeNode t = new TreeNode(val);
            t.left = Deserialize();
            t.right = Deserialize();
            return t;
        }
    }
}
