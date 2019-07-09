package niuke.jian_zhi_offer;

/**
 * @author CheNbXxx
 * @description 求第N个丑数, 典型DP问题
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 10:19
 */
public class Offer33 {
    public class Solution {
        public int GetUglyNumber_Solution(int index) {
            int[] resArray = new int[index];
            resArray[0] = 1;
            int index2 = 0, index3 = 0, index5 = 0;
            for (int i = 1; i < index; i++) {
                resArray[i] = Math.min(resArray[index2] * 2, Math.min(resArray[index3] * 3, resArray[index5] * 5));
                if (resArray[i] == resArray[index2] * 2) {
                    index2++;
                }
                if (resArray[i] == resArray[index3] * 3) {
                    index3++;
                }
                if (resArray[i] == resArray[index5] * 5) {
                    index5++;
                }
            }
            return resArray[index - 1];
        }
    }
}
