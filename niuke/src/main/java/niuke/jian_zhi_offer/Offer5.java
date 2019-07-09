package niuke.jian_zhi_offer;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author chen
 * @description 用两个栈实现队列功能，栈是先入后出(FILO)而队列是先入先出(FIFO)
 * @email ai654778@vip.qq.com
 * @date 19-2-2
 */
@Slf4j
public class Offer5 {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        solution.push(5);

        log.info("{},{},{},{},{}", solution.pop(), solution.pop(), solution.pop(), solution.pop(), solution.pop());
    }

    public static class Solution {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            // 入栈的时候利用第二个栈逆序存放
            // 数据具体还是存在stack2
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

        }

        public int pop() {
            return stack2.pop();
        }
    }
}
