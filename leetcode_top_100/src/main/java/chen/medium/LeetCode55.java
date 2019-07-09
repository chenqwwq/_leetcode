package chen.medium;

/**
 * 55. Jump Game
 *
 * @author chen
 * @date 19-5-12
 */
public class LeetCode55 {
    class Solution {
        public boolean canJump(int[] nums) {

            // DP解决 每次记录能到达的最大距离
            int maxDistance = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 移动距离减1
                if (--maxDistance < 0) {
                    return false;
                }
                maxDistance = Math.max(nums[i], maxDistance);
            }
            return true;
        }
    }
}
