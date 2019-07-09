package chen.medium;

/**
 * @author chen
 * @date 19-4-21
 */
public class LeetCode11_1 {
    class Solution {
        public int maxArea(int[] height) {
             // 左右双节点
            int left = 0,
                right = height.length - 1,
                max = Integer.MIN_VALUE,
                h;

            while (left < right){
                h = Math.min(height[left], height[right]);
                max = Math.max(max,(right - left) * h);
                // 以下两个循环逻辑,起码有一个要执行一次
                while (left < right && height[left] <= h){
                    left++;
                }
                while (left < right && height[right] <= h){
                    right--;
                }
            }
            return max;
        }
    }
}
