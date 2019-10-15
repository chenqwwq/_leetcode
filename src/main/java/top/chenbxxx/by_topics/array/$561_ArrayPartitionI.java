package top.chenbxxx.by_topics.array;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * Easy
 * <p>
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 *
 * @author bingxin.chen
 * @date 2019/10/15 12:17
 */
public class $561_ArrayPartitionI {
    class Solution {

        // fixme: 使用自定义桶排序完成

        public int arrayPairSum(int[] nums) {
            // java自带的排序Api
            Arrays.sort(nums);

            int res = 0;
            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }

            return res;
        }
    }
}
