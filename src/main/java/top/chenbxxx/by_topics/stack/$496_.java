package top.chenbxxx.by_topics.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chen
 * @date 2019/10/23 上午8:38
 */
public class $496_ {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            // 遍历入栈，入map<num,index>
            Map<Integer, Integer> nums2Map = new HashMap<>(nums2.length);
            Stack<Integer> nums2Stack = new Stack<>();

            for (int i = 0; i < nums2.length; ) {
                nums2Stack.push(nums2[i]);
                nums2Map.put(nums2[i], ++i);
            }

            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int res = -1;
                while (nums2Stack.sta)
            }

        }
    }
}
