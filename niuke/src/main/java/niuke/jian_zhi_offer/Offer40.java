package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 找到数组中仅仅出现了一次的的两个数字，其他都出现了两次
 * 刚开始完全不知道考点在哪，Set竟然也过了
 * google一下发现考点在位运算，稍微看了一下思路自己写写看吧。
 * @email chenbxxx@gmail.con
 * @date 2019/2/15 10:38
 */
public class Offer40 {
    public static void main(String[] args) {
        int[] a = new int[1];
        int[] b = new int[1];
//		new Offer40().new Solution().FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5},a,b);
        int num = 2;
        System.out.println(num >> 1);
        System.out.println(num);
    }

    public class Solution {
//		public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//			Set<Integer> set = new HashSet<>();
//			for (int i : array){
//				if(set.contains(i)){
//					set.remove(i);
//				}else{
//					set.add(i);
//				}
//			}
//			final Object[] objects = set.toArray();
//			num1[0] = (int) objects[0];
//			num1[0] = (int) objects[1];
//		}

        public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
            if (array == null || array.length == 0) {
                return;
            }
            // 两个相同的数字异或结果是0
            // 所以异或一轮之后,结果就是两个仅出现一次的数字的异或
            int res = 0;
            for (int i : array) {
                res ^= i;
            }
            // 找到第一个·1·位
            int bit1Index = 0;
            while ((res >> bit1Index & 1) == 0 && bit1Index <= Integer.SIZE) {
                bit1Index++;
            }
            // 根据bit1Index的位置是否为1将数组分为两个部分,分别遍历异或
            for (int i : array) {
                if ((i >> bit1Index & 1) == 1) {
                    num1[0] ^= i;
                } else {
                    num2[0] ^= i;
                }
            }
        }
    }
}
