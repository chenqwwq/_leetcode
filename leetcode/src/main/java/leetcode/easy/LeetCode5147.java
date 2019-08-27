package leetcode.easy;

/**
 * 5147. 递减元素使数组呈锯齿状
 * 题目难度 Easy
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都小于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 * <p>
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * <p>
 * 题目描述好像有问题,奇数索引对应的大于相邻元素
 *
 * @author chen
 * @date 2019/8/4 上午11:19
 */
//public class LeetCode5147 {
//    class Solution {
//        public int movesToMakeZigzag(int[] nums) {
//            // 一次遍历求出两种锯齿方式的操作次数
//            // x表示偶数索引大于相邻
//            // y表示奇数索引大于相邻
//            int x = 0,y = 0;
//
//            // 计算头结点
//            y += Math.max(0,nums[0] - nums[1] + 1);
//
//            // 计算尾节点
//            if((nums.length - 1) % 2 == 0){
//                //
//                x += Math.max(0,nums[nums.length - 1] - nums[nums.length - 2] + 1);
//            }else{
//                y += Math.max(0,nums[])
//            }
//
//            for (int i = 1;i < nums.length - 1;i++){
//                // 偶数索引时判断奇数索引大于偶数索引的情况
//                if(i % 2 == 0) {
//                    // 奇数索引的值要大于偶数索引
//                    y +=(Math.max(0,nums[i] - nums[i-1]) + Math.max(0,nums[i] - nums[i + 1]));
//                }else{
//                    x += (Math.max(0,nums[i - 1] - nums[i]) + Math.max(0,nums[i+1] - nums[i]));
//                }
//            }
//        }
//    }
//}
