package top.chenqwwq.pat.advanced._1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021-03-25
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        // 输入
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int cnt = Integer.parseInt(in.readLine());
        if (cnt == 0) {
            System.out.printf("%d %d %d\n", 0, 0, 0);
            return;
        }

        final String[] str = in.readLine().split(" ");

        // dp[i] 表示以 str[i] 为末尾的最大和
        // dp[i] = Math.max(dp[i-1]+curr,curr)
        // 首位默认为0
        int[] dp = new int[cnt];
        dp[0] = Integer.parseInt(str[0]);
        int max = dp[0], ms = 0, me = 0, cs = 0, ce = 0;

        for (int i = 1; i < cnt; i++) {
            final int curr = Integer.parseInt(str[i]), sum = dp[i - 1] + curr;
            if (sum > curr) {
                dp[i] = sum;
                ce = i;
                if (dp[i] > max) {
                    max = dp[i];
                    ms = cs;
                    me = ce;
                }
            } else if (sum == curr) {
                dp[i] = curr;
            } else {
                dp[i] = curr;
                cs = ce = i;
            }
        }

        if (max < 0) {
            System.out.printf("%d %d %d\n", 0, 0, str.length - 1);
        }
        System.out.printf("%d %d %d\n", max, Integer.parseInt(str[ms]), Integer.parseInt(str[me]));
    }
}
