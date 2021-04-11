package top.chenqwwq.pat.advanced._1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 上一个题解最后一个用例一直超时，尝试用并查集写
 *
 * @author chen
 * @date 2021/4/11
 **/
public class Main_UnionFind {
    static int[][] highways;
    static int[] uf;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = reader.readLine().split(" ");
        final int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]), k = Integer.parseInt(line[2]);
        uf = new int[n];
        // 读取道路信息
        highways = new int[m][2];
        for (int i = 0; i < m; i++) {
            final String[] data = reader.readLine().split(" ");
            highways[i] = new int[]{Integer.parseInt(data[0]) - 1, Integer.parseInt(data[1]) - 1};
        }

        final String[] occupy = reader.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            final int city = Integer.parseInt(occupy[i]) - 1;
            // 初始化并查集
            for (int j = 0; j < n; j++) {
                uf[j] = j;
            }
            for (int[] highway : highways) {
                if (highway[0] == city || highway[1] == city) {
                    continue;
                }
                if (find(highway[0]) != find(highway[1])) {
                    uf[highway[0]] = highway[1];
                }
            }
            int cnt = 0;
            for (int c = 0; c < n - 1; c++) {
                if (c != city && find(c) != c) {
                    cnt++;
                }
            }
            System.out.printf("%d\n", cnt);

        }
    }

    static int find(int n) {
        while (uf[n] != n) {
            n = uf[uf[n]];
        }
        return n;
    }
}
