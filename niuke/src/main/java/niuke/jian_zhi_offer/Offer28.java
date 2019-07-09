package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 求出现次数超过一半的数字
 * @email chenbxxx@gmail.com
 * @date 19-2-13
 */
public class Offer28 {
    public static void main(String[] args) {
        new Solution().MoreThanHalfNum_Solution(new int[]{4, 2, 4, 1, 4, 2});
    }

    public static class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int sign = array[0], sum = 1;
            for (int i = 1; i < array.length; i++) {
                if (sum == 0) {
                    sign = array[i];
                    sum++;
                } else {
                    if (sign == array[i]) {
                        sum++;
                    } else {
                        sum--;
                    }
                }
            }
            return moreThanHalf(array, sign) ? sign : 0;
        }

        /**
         * 因为题目中并不保证一定存在这个数字,所以还需要做另外的判断
         */
        private boolean moreThanHalf(int[] array, int sign) {
            int count = 0;
            for (int i : array) {
                if (i == sign) {
                    count++;
                }
            }

            return count > array.length >> 1;
        }
    }
}
