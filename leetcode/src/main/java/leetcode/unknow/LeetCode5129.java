package leetcode.unknow;

/**
 * @author chen
 * @date 19-7-14 上午11:03
 */
public class LeetCode5129 {

    public static void main(String[] args) {
        System.out.println(new LeetCode5129().new Solution().longestWPI(new int[]{8, 10, 6, 16, 5}));
    }

    class Solution {
        public int longestWPI(int[] hours) {
            int res = 0;
            int[] nums = new int[hours.length];
            int[] lei = new int[hours.length];
            int[] bulei = new int[hours.length];

            nums[0] = hours[0] > 8 ? 1 : 0;
            lei[0] = nums[0];
            bulei[0] = 1 - nums[0];
            res = nums[0];

            for (int i = 1; i < hours.length; i++) {
                if (hours[i] > 8) {
                    if (lei[i - 1] + 1 > bulei[i - 1]) {
                        nums[i] = lei[i - 1] + bulei[i - 1] + 1;
                    } else {
                        nums[i] = 1;
                    }
                    lei[i] = lei[i - 1] + 1;
                    bulei[i] = bulei[i - 1];
                } else {
                    if (lei[i - 1] > bulei[i - 1] + 1) {
                        nums[i] = nums[i - 1] + 1;
                    } else {
                        nums[i] = 0;
                    }
                    lei[i] = lei[i - 1];
                    bulei[i] = bulei[i - 1] + 1;
                }

                res = Math.max(nums[i], res);
            }

            return res;
        }
    }
}
