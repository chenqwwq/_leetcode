package chen.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description 根据身高重建队列
 * 说实话一开始并不知道这题目啥意思，后面发现可能就是把队列调整到合理。
 * @email chenbxxx@gmail.con
 * @date 2019/2/26 14:17
 */
public class LeetCode406 {
	class Solution {
		/**
		 * [身高h][队列前面不低于他的人k]
		 * 先将people按照h降序,k升序排列,然后将其按照k插入对应的位置，
		 * 因为降序排列之后,从前往后遍历 前面的都比他大
		 */
		public int[][] reconstructQueue(int[][] people) {
			Arrays.parallelSort(people,new myComparator());

			List<int[]> list = new LinkedList<>();
			for (int[] i : people){
				list.add(i[1],i);
			}

			return list.toArray(new int[people.length][]);
		}

		class myComparator implements Comparator<int[]> {

			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
			}
		}
	}
}
