package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 判断树的后序遍历
 * 4
 * / \
 * 2   6
 * / \  / \
 * 1  3 5   7
 * 后序遍历: 1 3 2 5 7 6 4
 * 从中可以看出
 * 1. 父节点总是在一个阶段的末尾,最末尾的节点就是根节点
 * 2. 从根节点往前,第一个大于的数就为右节点,第一个小于的数就为左节点
 * 3. 从后往前遍历,找到第一个小于他的数字,在这之前的数字都比他小,在这之后的都比他大,
 * 4. 继续迭代
 * @email chenbxxx@gmail.com
 * @date 19-2-12
 */
public class Offer23 {
    public static void main(String[] args) {
        new Solution().VerifySquenceOfBST(new int[]{1, 3, 2, 5, 7, 6, 4});
    }

    public static class Solution {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence == null || sequence.length == 0) {
                return false;
            }
            return check(sequence, 0, sequence.length - 1);
        }

        /**
         * @param start 基0
         * @return
         */
        private boolean check(int[] sequence, int start, int end) {
            if (start >= end) {
                return true;
            }
            // 确定父节点
            int parent = sequence[end], sign = -1;
            // 找到左子树的根节点位置
            for (int i = end - 1; i >= start; i--) {
                if (sequence[i] < parent) {
                    sign = i;
                    break;
                }
            }
            // 判断该位置前后的大小
            for (int i = sign - 1; i >= start; i--) {
                if (sequence[i] > parent) {
                    return false;
                }
            }
            for (int i = sign + 1; i < end; i++) {
                if (sequence[i] < parent) {
                    return false;
                }
            }
            // 递归左右子树
            return check(sequence, start, sign) && check(sequence, sign + 1, end - 1);
        }
    }
}
