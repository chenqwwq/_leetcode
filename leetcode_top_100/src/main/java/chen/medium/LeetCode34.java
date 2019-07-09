package chen.medium;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * @author chen
 * @date 19-5-12
 */
public class LeetCode34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int start = -1, end = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (start == -1) {
                        start = i;
                    }
                    end = i;
                }
            }

            return new int[]{start, end};
        }
    }
}
