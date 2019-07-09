package chen.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bingxin.chen
 * @date 2019/3/21 11:01
 */
public class LeetCode56 {

    public static void main(String[] args) {
        ArrayList<Interval> objects = new ArrayList<>();
        objects.add(new Interval(1, 3));
        objects.add(new Interval(2, 6));
        objects.add(new Interval(8, 10));
        objects.add(new Interval(15, 18));
        System.out.println(new LeetCode56().new Solution().merge(objects));
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class Solution {
        /**
         * faster than 32.48%
         */
        public List<Interval> merge(List<Interval> intervals) {
            LinkedList<Interval> res = new LinkedList<>();
            if (intervals == null || intervals.isEmpty()) {
                return res;
            }
            intervals.sort(Comparator.comparingInt(a -> a.start));
            res.add(intervals.get(0));
            /*
             * faster than 8.06%
             * for (int i = 0; i < intervals.size() - 1; ) {
             *   Interval curr = intervals.get(i);
             *   Interval next = intervals.get(i + 1);
             *   if (curr.end >= next.start) {
             *       intervals.set(i, new Interval(curr.start, Math.max(curr.end,next.end)));
             *       intervals.remove(i + 1);
             *   } else {
             *      i++;
             *   }
             * }
             */
            int i = 0;
            while (++i < intervals.size()) {
                Interval last = res.getLast();
                Interval interval = intervals.get(i);
                if (last.end >= interval.start) {
                    res.set(res.size() - 1, new Interval(last.start, Math.max(last.end, interval.end)));
                } else {
                    res.add(interval);
                }
            }
            return res;
        }
    }
}
