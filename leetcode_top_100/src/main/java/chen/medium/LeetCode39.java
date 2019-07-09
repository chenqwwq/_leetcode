package chen.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 1. 提示是回溯算法
 * 2. 参考一下别人的思路DFS
 *
 * @author bingxin.chen
 * @date 2019/3/14 16:09
 */
public class LeetCode39 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new LeetCode39().new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists.size());
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return null;
            }
            // 先排序
            Arrays.sort(candidates);
            dfs(candidates, 0, target, 0, new ArrayList<>());
            return result;
        }

        private void dfs(int[] candidates, int index, int target, int sum, List<Integer> curr) {
            // 首先判断结果符合的
            if (sum == target) {
                result.add(new ArrayList<>(curr));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (sum + candidates[i] > target) {
                    break;
                }
                // 加上路径
                curr.add(candidates[i]);
                // 递归调用
                dfs(candidates, i, target, sum + candidates[i], curr);
                // 回退最后一个
                curr.remove(curr.size() - 1);
            }
        }
    }
}
