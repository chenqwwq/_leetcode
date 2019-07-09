package niuke.jian_zhi_offer;


import java.util.LinkedList;
import java.util.List;

/**
 * @author chen
 * @description 圆圈中最后剩下的数
 * @email chenbxxx@gmail.com
 * @date 19-2-17
 */
public class Offer46 {
    public static void main(String[] args) {
        new Offer46().new Solution().LastRemaining_Solution(5, 3);
    }

    public class Solution {
        public int LastRemaining_Solution(int n, int m) {
            if (n == 0 || m == 0) {
                return -1;
            }
            // 采用模拟法
            // 因为会有大量的删除操作,所以采用链表速度会更快一点
            List<Integer> childes = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                childes.add(i);
            }
            int count = 0, i = 0;
            for (; childes.size() > 1; i++) {
                count++;
                // 循环遍历
                i = i == childes.size() ? 0 : i;
                if (count % m == 0) {
                    childes.remove(i);
                    i--;
                }
            }
            return childes.get(0);
        }
    }
}
