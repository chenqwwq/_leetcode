package top.chenqwwq.leetcode.daily._20210719;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1838. 最高频元素的频数
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * <p>
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 *
 * @author chen
 * @date 2021/7/19
 **/
public class Solution {
	public int maxFrequency(int[] nums, int k) {
		// num -> cnt
		Map<Integer, Integer> hash = new HashMap<>();
		for (int num : nums) {
			hash.put(num, hash.getOrDefault(num, 0) + 1);
		}

		final List<Integer> numList = new ArrayList<>(hash.keySet());
		numList.sort((o1, o2) -> Integer.compare(o2, o1));

		int ans = -1;
		final int n = numList.size();

		for (int i = 0; i < n; i++) {
			final int num1 = numList.get(i);
			int idx = i + 1, target = k, cnt1 = hash.get(num1);
			while (idx < n && target > 0) {
				final Integer num2 = numList.get(idx), cnt2 = hash.get(num2), diff = num1 - num2;
				if (target - diff * cnt2 <= 0) {
					cnt1 += target / diff;
				} else {
					cnt1 += cnt2;
					target -= diff * cnt2;
				}
				idx++;
			}
			ans = Math.max(ans, cnt1);
		}

		return ans;
	}
}