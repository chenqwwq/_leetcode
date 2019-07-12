package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 15. 3Sum
 * Medium
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author chen
 * @date 19-7-12 上午8:24
 */
public class LeetCode15 {
    public void binarySearch(int[] nums, int target, int start, int end) {
        int ts = start, te = end;
        while (ts <= te) {
            int mid = ts + (ts + te) / 2;
            if (nums[mid] < target) {
                ts = mid + 1;
            } else if (nums[mid] > target) {
                te = mid - 1;
            } else {
                List<Integer> list = new ArrayList<Integer>() {{
                    add(nums[start]);
                    add(nums[end]);
                    add(nums[mid]);
                }};

                res.add(list);
            }
        }
    }

    class Solution {

        private HashSet<List<Integer>> res = new HashSet<>();

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            // 首先的思路是排序
            // 双指针定在两边,二分往中间查找

            // 先排序
            Arrays.sort(nums);

            // 定死末尾位置
            for (int i = 0, j = nums.length - 1; i < j - 1; i++) {
                int sum = nums[i] + nums[j];
                binarySearch(nums, sum & (1 << 31), i, j);
            }
        }
            return new ArrayList<>(res);
    }
}
}
