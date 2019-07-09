package niuke.jian_zhi_offer;

import java.util.Stack;

/**
 * @author chen
 * @description 判断入栈和出栈顺序是否符合规则
 * @email chenbxxx@gmail.com
 * @date 19-2-10
 */
public class Offer21 {
    public static void main(String[] args) {
        System.out.println(new Solution().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

    public static class Solution {
        /**
         * @param pushA 入栈顺序
         * @param popA  出栈顺序
         * @return 是否合法
         */
        public boolean IsPopOrder(int[] pushA, int[] popA) {
            if (popA.length == 0 || pushA.length != popA.length) {
                return false;
            }

            Stack<Integer> stack = new Stack<>();
            int pushSign = 0, popSign = 0;
            for (; popSign < popA.length; popSign++) {
                if (stack.size() > 0 && stack.peek() == popSign) {
                    // 如果想要的元素就在栈顶,直接弹出
                    stack.pop();
                } else {
                    // 将到i值为止的元素全部入栈
                    for (; pushSign < pushA.length; pushSign++) {
                        stack.push(pushA[pushSign]);
                        if (stack.peek() == popA[popSign]) {
                            // 防止末尾元素重新添加
                            pushSign++;
                            break;
                        }
                    }
                    // 特殊检查,是否有一个数组遍历到末尾
                    if (stack.peek() != popA[popSign]) {
                        return false;
                    } else {
                        // 将压入栈顶的元素弹出
                        stack.pop();
                    }
                }
            }
            return true;
        }
    }
}
