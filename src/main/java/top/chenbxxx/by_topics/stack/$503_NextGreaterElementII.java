package top.chenbxxx.by_topics.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 * Medium
 * <p>
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 *
 * @author chen
 * @date 2019/10/24 上午8:31
 */
public class $503_NextGreaterElementII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $503_NextGreaterElementII().new Solution().nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            // 循环数组的单调栈求法

            int[] res = new int[nums.length];

            Stack<Integer> stack = new Stack<>();
            stack.push(nums[nums.length - 1]);

            for (int i = nums.length - 2; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                // 经过上面的循环之后,栈中的首元素肯定比nums[i]大

                res[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }

            while (!stack.isEmpty() && stack.peek() <= nums[nums.length - 1]) {
                stack.pop();
            }
            res[nums.length - 1] = stack.isEmpty() ? -1 : stack.peek();

            return res;
        }
    }
}
