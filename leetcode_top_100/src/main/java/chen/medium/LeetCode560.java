package chen.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560: 数组中和为K的连续子数组
 *
 * @author bingxin.chen
 * @date 2019/4/19 13:24
 */
public class LeetCode560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // *************************************************************************
            // 整体思路：
            // Map中存放的是0~n未知的连续子数组相加的和
            // 0~m的连续子数组 - 0~n的连续子数组 = 0~n-m的连续自数组
            // 两个连续自数组的和相减等于k是就表示存在连续子数组存在
            // *************************************************************************
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
            map.put(0, 1);
            int sum = 0,res = 0;
            for (int n : nums) {
                sum += n;
                if(map.containsKey(sum - k)){
                    res += map.get(sum - k);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }

            return res;
        }
    }
}
