package niuke.jian_zhi_offer;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author chen
 * @description 实现在栈中得到最小元素的函数
 * 1. 空间换时间 用优先级队列再存储一份
 * @email chenbxxx@gmail.com
 * @date 19-2-9
 */
@Slf4j
public class Offer20 {
    public static void main(String[] args) {

        //["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
        Solution solution = new Solution();
        solution.push(3);
        log.info(solution.min() + "");
        solution.push(4);
        log.info(solution.min() + "");
        solution.push(2);
        log.info(solution.min() + "");
        solution.push(3);
        log.info(solution.min() + "");
        solution.pop();
        log.info(solution.min() + "");
        solution.pop();
        log.info(solution.min() + "");
        solution.pop();
        log.info(solution.min() + "");
        solution.push(0);
        log.info(solution.min() + "");
    }

    public static class Solution {
        private Stack<Integer> stack = new Stack<>();
        private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public void push(int node) {
            stack.push(node);
            priorityQueue.offer(node);
        }

        public void pop() {
            priorityQueue.remove(stack.pop());
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            final Integer peek = priorityQueue.peek();
            return peek == null ? 0 : peek;
        }
    }

}
