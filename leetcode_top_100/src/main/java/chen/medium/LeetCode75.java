package chen.medium;

/**
 * 75. 颜色分类(荷兰国旗问题)
 * https://www.cnblogs.com/gnuhpc/archive/2012/12/21/2828166.html
 *
 * @author bingxin.chen
 * @date 2019/4/24 10:21
 */
public class LeetCode75 {
    public static void main(String[] args) {
        new LeetCode75().new Solution().sortColors(new int[]{2, 2, 0});
    }

    class Solution {
        public void sortColors(int[] nums) {
            //************** 解题思路 ****************
            // start 表示前部位置 end 表示后部位置
            // 使用curr指针遍历
            //   1.) 值为0就和start交换,start++
            //   2.) 值为2就和end交换,end--
            // **************************************

            if (nums == null || nums.length <= 1) {
                return;
            }

            int start = -1, end = nums.length, curr = 0;


            while (curr < end) {
                switch (nums[curr]) {
                    case 0:
                        swap(nums, curr++, ++start);
                        break;
                    case 2:
                        swap(nums, curr, --end);
                        break;
                    default:
                        curr++;
                        break;
                }
            }

        }

        private void swap(int[] nums, int src, int des) {
            int temp = nums[src];
            nums[src] = nums[des];
            nums[des] = temp;
        }
    }
}
