package niuke.jian_zhi_offer;

/**
 * @author chen
 * @description 求base的exponent次方
 * @email chenbxxx@gmail.com
 * @date 19-2-5
 */
public class Offer12 {
    /**
     * @param base     基数
     * @param exponent 需要判断exponent的正负
     * @return
     */
    public double Power(double base, int exponent) {

        if (base >= -0.00001 && base <= 0.00001) {
            return 0;
        }

        // exponent取绝对值
        int absExp = Math.abs(exponent);

        double res = handle1(base, absExp);

        return exponent > 0
                ? res
                : 1 / res;
    }

    private double handle1(double base, int exponent) {
        double result = 1d;
        while (exponent-- > 0) {
            result *= base;
        }
        return result;
    }

    /**
     * 利用位移操作
     */
    private double handle2(double base, int exponent) {
        int res = 1;
        while (exponent != 0) {
            // 取最右位 不为1就相乘
            if ((exponent & 1) == 1) {
                res *= base;
            }
            base *= base;
            // exponent右移一位
            exponent >>= 1;
        }
        return res;
    }
}
