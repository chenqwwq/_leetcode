package leetcode.medium;

import java.util.LinkedList;

/**
 * 526. Beautiful Arrangement
 * Medium
 * <p>
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 * <p>
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * <p>
 * <p>
 * Now given N, how many beautiful arrangements can you construct?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation:
 * <p>
 * The first beautiful arrangement is [1, 2]:
 * <p>
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * <p>
 * The second beautiful arrangement is [2, 1]:
 * <p>
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * <p>
 * <p>
 * Note:
 * <p>
 * N is a positive integer and will not exceed 15.
 * <p>
 * <p>
 * 回溯+剪枝
 * <p>
 * 首次提交,剪枝错误
 *
 * @author bingxin.chen
 * @date 2019/7/11 16:09
 */
public class LeetCode526 {
    public static void main(String[] args) {
        System.out.println(new LeetCode526().new Solution().countArrangement(2));
    }

    class Solution {
        // the result
        int resSum = 0;

        // Initial array
        LinkedList<Integer> list = new LinkedList<>();

        public int countArrangement(int N) {
            for (int i = 1; i <= N; i++) {
                list.add(i);
            }
            dfs(0, N, list);
            return resSum;
        }

        public void dfs(int currIndex, int N, LinkedList<Integer> remaining) {
            // dfs + 回溯 + 剪枝
            if (currIndex == N && remaining.size() == 0) {
                resSum++;
                return;
            }
            // 外部数组
            for (int i = currIndex; i < N; i++) {
                // 遍历剩余数组
                inner:
                for (int j = 0; j < remaining.size(); j++) {
                    // 取
                    final Integer integer = remaining.get(j);
                    // 判断
                    if (integer % (i + 1) == 0 || (i + 1) % integer == 0) {
                        // 先删除
                        remaining.remove(integer);
                        //
                        dfs(currIndex + 1, N, remaining);
                        // 加回去
                        remaining.add(j, integer);
                        break inner;
                    }
                }
            }
        }
    }
}
