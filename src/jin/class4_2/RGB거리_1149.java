package jin.class4_2;

import java.io.*;
import java.util.*;

public class RGB거리_1149 {

    static int N;
    static int[][] data;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        data = new int[N][3];
        dp = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = data[i - 1][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = data[i - 1][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = data[i - 1][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
        br.close();
    }
}
