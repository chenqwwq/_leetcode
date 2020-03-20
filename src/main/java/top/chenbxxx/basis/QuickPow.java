package top.chenbxxx.basis;

/**
 * 快速幂 Quick Pow
 * 用于求a ^ n时,能够将O(n)的时间复杂度优化到O(log n)
 *
 * @author chen
 * @date 2020 /3/16 上午9:28
 */
public class QuickPow {

    /**
     * 求num的n次方
     */

    /**
     * 非递归形式
     */
    public long quickPow(int num, int n) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= num;
            }
            num *= num;
            n >>= 1;
        }
        return res;
    }

    /**
     * 递归形式
     */
    public long quickPow2(int num, int n) {
        if (n == 0) {
            return 1;
        }
        // 递归求解
        long res = quickPow(num, n >> 1);
        return res * res * ((n & 1) == 1 ? num : 1);
    }
}
