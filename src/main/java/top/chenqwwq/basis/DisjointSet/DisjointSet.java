package top.chenqwwq.basis.DisjointSet;

import java.util.Arrays;

/**
 * 并查集的Java数组实现
 *
 * @author chen
 * @date 2020/7/13 下午10:17
 */
public class DisjointSet {
    private int[] tree;

    public DisjointSet(int n) {
        this.tree = new int[n];
        Arrays.fill(tree, -1);
    }

    public int root(int n) {
        // 找到x节点的根节点
        int node = n;
        while (tree[node] != -1) {
            node = tree[node];
        }
        return node;
    }

    public void union(int x, int y) {
        int xRoot = root(x);
        int yRoot = root(y);
        if (xRoot != yRoot) {
            tree[xRoot] = yRoot;
        }
    }


}
