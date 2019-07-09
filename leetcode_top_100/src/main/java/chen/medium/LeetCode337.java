package chen.medium;

/**
 * @author chen
 * @description 打家劫舍的题型, 围绕二叉树
 * 1. 初时理解为奇偶的节点求和之后选最大
 * 2. 考虑到可以相隔两层求和,尝试使用动态规划和贪心算法
 * 记下每次选择当下的最优解
 * 3. 问题好像还在,先返回去做打家劫舍前两道
 * 4. 感觉对动态规划有了更好的认识吧 因为是不直接相连就可以了
 * 所以不一定在同一层 左右子树需要分开计算
 * @email chenbxxx@gmail.com
 * @date 19-3-3
 */
public class LeetCode337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);

        root.left = root1;
        root1.left = root2;
        root2.left = root3;

        System.out.println(new LeetCode337().new Solution().rob(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution1 {
        public int rob(TreeNode root) {

            return root == null ? 0 : handle(root);
        }

        public int handle(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return root.val;
            }
            int a = 0, b = root.val;
            if (root.left != null) {
                a = a + handle(root.left);
                b = b + handle(root.left.left) + handle(root.left.right);
            }
            if (root.right != null) {
                a = a + handle(root.right);
                b = b + handle(root.right.left) + handle(root.right.right);
            }
            return Math.max(a, b);
        }
    }

    /**
     * 以下是官方答案
     */
    class Solution {
        public int[] helper(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            // 0位: 表示包含此位置的总值
            // 1位: 表示不包含此位置的总值
            int[] rob = new int[2];
            int[] robLeft = helper(root.left);
            int[] robRight = helper(root.right);
            // 不包含下层数值的和
            rob[0] = robLeft[1] + robRight[1] + root.val;
            // 包涵下层数组,但不包含本层数值的和
            rob[1] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
            return rob;
        }

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] rob = helper(root);
            return Math.max(rob[0], rob[1]);
        }
    }
}
