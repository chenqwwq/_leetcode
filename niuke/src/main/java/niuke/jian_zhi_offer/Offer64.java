package niuke.jian_zhi_offer;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CheNbXxx
 * @description 滑动窗口的最大值
 * @email chenbxxx@gmail.con
 * @date 2019/2/18 15:15
 */
public class Offer64 {
    public static void main(String[] args) throws InterruptedException {
//		System.out.println(new Offer64().new Solution().maxInWindows(new int[]{2,3,4,2,6,2,5,1},3));
        ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        final Condition condition2 = lock.newCondition();

        lock.lock();
        condition.await();
        System.out.println("Hello");
        condition2.await();
    }

    public class Solution {
        private ArrayList<Integer> maxArray;

        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            if (num == null || num.length == 0 || size <= 0) {
                return new ArrayList<>();
            }
            maxArray = new ArrayList<>(num.length - size + 1);
            handle(num, 0, size - 1, -1);
            return maxArray;
        }

        private void handle(int[] num, int start, int end, int pre) {
            if (end >= num.length) {
                return;
            }
            if (pre >= start && pre <= end) {
                maxArray.add(Math.max(num[pre], num[end]));
                pre = maxArray.get(start) == num[end] ? end : pre;
            } else {
                pre = getMaxIndex(num, start, end);
                maxArray.add(num[pre]);
            }
            handle(num, start + 1, end + 1, pre);
        }

        private int getMaxIndex(int[] num, int start, int end) {
            if (num == null || num.length == 0) {
                return -1;
            }
            int max = start;
            for (int i = start + 1; i <= end; i++) {
                max = num[max] > num[i] ? max : i;
            }
            return max;
        }
    }

}
