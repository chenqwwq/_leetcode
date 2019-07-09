package chen.medium;

/**
 * 33. Search in Rotated Sorted Array
 *
 * @author chen
 * @date 19-5-12
 */
public class LeetCode33 {
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        private int binarySearch(int[] nums, int start, int end, int target) {
            if (start > end) {
                return -1;
            }
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            // 此时nums[mid]肯定不是,可以排除
            // 区分半边有序半边无序
            // 右半边数组有序,直接进行二分
            if (nums[mid] < nums[end]) {
                // 确定target所在区域
                return nums[mid] < target && target <= nums[end]
                        ? binarySearch(nums, mid + 1, end, target)
                        : binarySearch(nums, start, mid - 1, target);
            } else {
                // 右半边有序
                return nums[mid] > target && target >= nums[start]
                        ? binarySearch(nums, start, mid - 1, target)
                        : binarySearch(nums, mid + 1, end, target);
            }
        }
    }
}
