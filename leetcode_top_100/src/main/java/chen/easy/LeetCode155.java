package chen.easy;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author chen
 * @description MinStack
 * @email chenbxxx@gmail.com
 * @date 19-2-24
 */
public class LeetCode155 {
	class MinStack {

		/** 普通栈 */
		private Stack<Integer> stack;
		/** 小顶堆 */
		private PriorityQueue<Integer> queue;

		/** initialize your data structure here. */
		public MinStack() {
			stack = new Stack<>();
			queue = new PriorityQueue<>();
		}

		public void push(int x) {
			stack.push(x);
			queue.offer(x);
		}

		public void pop() {
			queue.remove(stack.pop());
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return queue.size() <= 0 ? -1 : queue.peek();
		}
	}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
