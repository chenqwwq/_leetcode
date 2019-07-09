package niuke.jian_zhi_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author CheNbXxx
 * @description 数据流中的中位数
 * @email chenbxxx@gmail.con
 * @date 2019/2/18 15:02
 */
public class Offer63 {
    public class Solution {
        /**
         * 大顶堆
         */
        private PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        /**
         * 小顶堆
         */
        private PriorityQueue<Integer> rightQueue = new PriorityQueue<>(Comparator.reverseOrder());
        /**
         * 已经加载的元素个数
         */
        private int count = 0;

        public void Insert(Integer num) {
            // 插入时需要保证leftQueue的数字都小于rightQueue
            if (++count % 2 == 1) {
                // 元素先填充到右边,再从右边弹出最小的加入左边,
                // 这样保证加入到左边的数字永远是右边中最小的，即右边的数字都大于左边
                rightQueue.add(num);
                leftQueue.add(rightQueue.poll());
            } else {
                leftQueue.add(num);
                rightQueue.add(leftQueue.poll());
            }
        }

        public Double GetMedian() {
            if (count % 2 == 1) {
                return Double.valueOf(leftQueue.peek());
            } else {
                return (leftQueue.peek() + rightQueue.peek()) / 2.0;
            }

        }


    }
}
