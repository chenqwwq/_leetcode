package niuke.jian_zhi_offer;

import java.util.Arrays;

/**
 * @author CheNbXxx
 * @description 将数组排成最小的数字, 考虑溢出问题需要转化为字符串处理
 * @email chenbxxx@gmail.con
 * @date 2019/2/14 10:07
 */
public class Offer32 {
    public class Solution {
        public String PrintMinNumber(int[] numbers) {
            StringBuilder stringBuffer = new StringBuilder();
            /**
             * 问题的关键就在于如何排序.
             */
            Arrays.stream(numbers).mapToObj(Integer::toString).sorted((o1, o2) -> {
                final Integer integer = Integer.valueOf(o1 + o2);
                final Integer integer1 = Integer.valueOf(o2 + o1);
                return integer > integer1 ? 1 : (integer.equals(integer1) ? 0 : -1);
            }).forEach(stringBuffer::append);

            return stringBuffer.toString();

        }
    }
}
