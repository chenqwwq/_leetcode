package top.chenqwwq;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	int[] p;

	public int maxEvents(int[][] e) {
		Arrays.sort(e, Comparator.comparingInt(o -> o[1]));
		// p表示从当前下标开始，已经使用到了第几天
		p = new int[100010];
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}

		int res = 0;
		for (int[] arr : e) {
			int day = find(arr[0]);
			// 当前天数可用
			if (day <= arr[1]) {
				res++;
				p[find(day)] = day + 1;
			}
		}
		return res;
	}

	// 路径压缩，参考并查集。查找已经用到了哪天
	private int find(int x) {
		return p[x] == x ? x : (p[x] = find(p[x]));
	}

	static class Single {
		static int cnt = 0;

		private Single() {
			cnt++;
		}

		public void single() {
			System.out.println(cnt);
		}
	}

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		final Class<Single> singleClass = Single.class;
		final Constructor<Single> declaredConstructor = singleClass.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		for (int i = 0; i < 10; i++) {
			final Single single = declaredConstructor.newInstance();
			single.single();
		}
	}
}
