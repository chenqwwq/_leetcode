package chen.medium;

/**
 * 11. 盛最多水的容器
 *
 * @author chen
 * @date 19-4-21
 */
public class LeetCode11 {
    class Solution {
        public int maxArea(int[] height) {
            // 纯暴力O(n^2)解法
            if (height == null || height.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < height.length; i++) {
                int heiGht = height[i];
                for (int j = 0; j < height.length; j++) {
                    if (height[j] >= heiGht) {
                        max = Math.max(max, Math.abs(i - j) * Math.min(heiGht, height[j]));
                    }
                }
            }
            return max;
        }
    }
}
