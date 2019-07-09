package chen.medium;

import java.util.*;

/**
 * @author CheNbXxx
 * @description 前k个高频元素
 * 1. TopK问题就想到了小顶堆
 * @email chenbxxx@gmail.con
 * @date 2019/2/26 15:08
 */
public class LeetCode347 {

    public static void main(String[] args) {
        new LeetCode347().new Solution().topKFrequent_byBucket(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    class Solution {
        /**
         * 大顶堆的解决方案
         */
        public List<Integer> topKFrequent(int[] nums, int k) {
            if (k > nums.length) {
                return null;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }

            PriorityQueue<HashMap.Entry<Integer, Integer>> queue = new PriorityQueue(new myCom());
            queue.addAll(map.entrySet());

            List<Integer> res = new ArrayList<>();
            while (k-- > 0) {
                res.add(queue.poll().getKey());
            }

            return res;
        }

        /**
         * 桶排序方法
         */
        public List<Integer> topKFrequent_byBucket(int[] nums, int k) {
            if (k > nums.length) {
                return null;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            // 建立num.length个桶
            List[] bucket = new List[nums.length + 1];
            for (int key : map.keySet()) {
                final Integer integer = map.get(key);
                if (bucket[integer] == null) {
                    bucket[integer] = new ArrayList();
                }
                bucket[integer].add(key);
            }

            List<Integer> res = new ArrayList<>();
            for (int i = bucket.length - 1; i > 0 && res.size() < k; i--) {
                if (bucket[i] != null) {
                    res.addAll(bucket[i]);
                }
            }
            return res;
        }

        class myCom implements Comparator<HashMap.Entry<Integer, Integer>> {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        }
    }
}
