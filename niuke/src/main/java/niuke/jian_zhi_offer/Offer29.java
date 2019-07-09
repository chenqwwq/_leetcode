package niuke.jian_zhi_offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chen
 * @description 求最小的k个数 用大顶堆完成
 * @email chenbxxx@gmail.com
 * @date 19-2-13
 */
public class Offer29 {
    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            if (input == null || input.length == 0 || input.length < k || k <= 0) {
                return new ArrayList<>();
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
            for (int i : input) {
                queue.add(i);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return new ArrayList<>(queue);
        }
    }
}
