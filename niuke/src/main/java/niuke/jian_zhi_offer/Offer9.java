package niuke.jian_zhi_offer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chen
 * @description n级跳台阶问题
 * /   1               n = 1
 * f(n) ——  2               n = 2
 * \   f(n-1)+f(n-2)+...+f(2)+f(1)   (n > 2)
 * 上面的表达式可以转化为 f(n) = 2 * f(n-1)
 * @email ai654778@vip.qq.com
 * @date 19-2-4
 */
@Slf4j
public class Offer9 {
    public static void main(String[] args) {
        log.info(new Offer9().JumpFloorII(4) + "");
    }

    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
