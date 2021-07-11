package top.chenqwwq.leetcode.week._248._2;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/7/4
 **/
public class Solution {
	public int eliminateMaximum(int[] dist, int[] speed) {
		// 每个怪兽到城市的时间
		final int n = dist.length;
		float[] times = new float[n];
		for (int i = 0; i < n; i++) {
			times[i] = 1.0f * dist[i] / speed[i];
		}
		Arrays.sort(times);

		int cnt = 0;
		for (float num : times) {
			if (cnt < num) {
				cnt++;
			} else {
				return cnt;
			}
		}
		return cnt;
	}
}