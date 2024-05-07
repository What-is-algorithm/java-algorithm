package jin.class4_2;

import java.io.*;
import java.util.*;

public class 내려가기_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        int[][] dp2 = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = dp2[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = dp2[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = dp2[i][2] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            dp[i][0] += Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] += Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][2] += Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        int max = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));

        for (int i = 1; i <= n; i++) {
            dp2[i][0] += Math.min(dp2[i - 1][0], dp2[i - 1][1]);
            dp2[i][1] += Math.min(dp2[i - 1][0], Math.min(dp2[i - 1][1], dp2[i - 1][2]));
            dp2[i][2] += Math.min(dp2[i - 1][1], dp2[i - 1][2]);
        }

        int min = Math.min(dp2[n][0], Math.min(dp2[n][1], dp2[n][2]));
        System.out.printf("%d %d\n", max, min);
    }
}
