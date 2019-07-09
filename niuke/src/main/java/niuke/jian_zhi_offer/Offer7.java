package niuke.jian_zhi_offer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chen
 * @description
 * @email ai654778@vip.qq.com
 * @date 19-2-4
 */
@Slf4j
public class Offer7 {
    public static void main(String[] args) {
        log.info(new Offer7().Fibonacci(3) + "");
    }

    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int i = 0, j = 1;
        while (--n > 0) {
            int k = i + j;
            i = j;
            j = k;
        }
        return j;
    }
}
