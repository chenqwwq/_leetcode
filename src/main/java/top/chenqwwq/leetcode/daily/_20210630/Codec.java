package top.chenqwwq.leetcode.daily._20210630;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chen
 * @date 2021-06-30
 **/
public class Codec {

	private static final TreeNode NULL = new TreeNode(Integer.MIN_VALUE);

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root == null ? NULL : root);
		while (!queue.isEmpty()) {
			final TreeNode poll = queue.poll();
			sb.append(",").append(poll.val);
			if (poll != NULL) {
				queue.add(poll.left == null ? NULL : poll.left);
				queue.add(poll.right == null ? NULL : poll.right);
			}
		}
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		final String[] split = data.split(",");
		if(split.length == 0){
			return null;
		}
		TreeNode root  = new TreeNode(Integer.valueOf(split[0]));
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new Codec().serialize(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, null)))))));
	}
}