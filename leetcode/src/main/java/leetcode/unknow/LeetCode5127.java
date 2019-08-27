package leetcode.unknow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen
 * @date 19-7-14 上午10:49
 */
public class LeetCode5127 {

    public static void main(String[] args) {
        System.out.println(new LeetCode5127().new Solution().relativeSortArray(new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31}, new int[]{}));
    }

    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            // 一遍遍历 value:count的映射
            for (int i : arr1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            List<Integer> list = new ArrayList<>();

            // 遍历arr2
            for (int i : arr2) {
                int sum = map.get(i);
                while (sum-- > 0) {
                    list.add(i);
                }
                map.remove(i);
            }

            // 遍历剩下的
            for (int i : map.keySet().stream().sorted().collect(Collectors.toList())) {
                int sum = map.get(i);
                while (sum-- > 0) {
                    list.add(i);
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
