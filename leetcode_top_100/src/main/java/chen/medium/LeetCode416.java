package chen.medium;

/**
 * 416. Partition equal subset sum 分割等和子集
 *
 * @author chen
 * @date 19-4-27
 */
public class LeetCode416 {
    class Solution {
        public boolean canPartition(int[] nums) {
//             排除极端情况
            if (nums == null || nums.length <= 1) {
                return false;
            }
            if (nums.length == 2) {
                return nums[0] == nums[1];
            }
            // 计算sum 是否为偶数
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) {
                return false;
            }

            //  dfs递归解法
            // 剪枝之后还是超出时间限制,改用动态数组
            // ================= 超出时间限制 ================
//            return recursive(nums,0,0,0,(sum / 2));


            // ============== 以0 1背包问题的思路解决 二维数组DP =============
            final int target = sum >> 1;
//            // dp2d[i][j]表示sums的前i个数组能否组成和为j的子集
//            boolean[][] dp2d = new boolean[nums.length][target+1];
//            dp2d[0][nums[0]] = true;
//            // 跳过第一行的判断
//            // dp2d[i][j] => dp[i - 1][j] || ((j - nums[i] >= 0) &&  dp2d[i - 1][j - nums[i]])
//            // dp[i - 1][j] 表示i位数组不计入当前子集
//            // dp2d[i - 1][j - nums[i]] 表示i位数字加入当前子集
//            for (int i = 1;i < nums.length;i++){
//                for (int j = 1;j <= target;j++){
//                    dp2d[i][j] = dp2d[i - 1][j] || ((j - nums[i] >= 0) &&  dp2d[i - 1][j - nums[i]]);
//                }
//            }
//            return dp2d[nums.length-1][target];

            // ================ 尝试一维数组解决 ==================
            boolean[] dp1d = new boolean[target + 1];
            dp1d[nums[0]] = true;
            for (int i = 1;i < nums.length;i++){
                // 继续从小到大的遍历会干扰大数的判断,导致重复加
                // 所以此处从最大值开始
                for(int j = target;j >= 0;j--){
                    dp1d[j] = dp1d[j] || ((j - nums[i] > 0) && dp1d[j - nums[i]]);
                }
            }

            return dp1d[target];
        }

        private boolean recursive(int[] nums, int i, int left, int right, int target) {
            // DFS + 剪枝
            if (left > target || right > target || nums.length <= i) {
                return false;
            }
            if (left == target || right == target) {
                return true;
            }

            return recursive(nums, i + 1, left + nums[i], right, target) || recursive(nums, i + 1, left, right + nums[i], target);
        }
    }

    public static void main(String[] args) {
        new LeetCode416().new Solution().canPartition(new int[]{2,2,3,5});
    }
}
