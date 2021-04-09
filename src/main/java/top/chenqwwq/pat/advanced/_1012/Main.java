package top.chenqwwq.pat.advanced._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 5 6
 * 310101 98 85 88
 * 310102 70 95 88
 * 310103 82 87 94
 * 310104 91 91 91
 * 310105 85 90 90
 * 310101
 * 310102
 * 310103
 * 310104
 * 310105
 * 999999
 * <p>
 * Sample Output:
 * 1 C
 * 1 M
 * 1 E
 * 1 A
 * 3 A
 * N/A
 *
 * @author chen
 * @date 2021-04-09
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = reader.readLine().split(" ");
        // 最后要的是排名和学科

        // N表示有N个学生  M表示查成绩的学生
        int N = Integer.parseInt(line[0]), M = Integer.parseInt(line[1]);
        // 首位是学号 后面是学科成绩
        int[][] scores = new int[N][5];

        // 读取每个学生的成绩
        for (int i = 0; i < N; i++) {
            final String[] tmp = reader.readLine().split(" ");
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                final int score = Integer.parseInt(tmp[0]);
                scores[i][j] = score;
                sum += score;
            }
            scores[i][3] = sum / 3;
        }

        Map<Integer, Integer> hash = new HashMap<>();
        // 分别按照 CMEA 排序
        for (int i = 1; i < 5; i++) {
            final int t = i;
            Arrays.sort(scores, Comparator.comparingInt(a -> a[t]));
            int j = 1;
            for (int[] score : scores) {

            }
        }
    }
}
