package jin.class4_2;

import java.io.*;
import java.util.*;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] data = new int[2][n];
            int[][] dp = new int[2][n + 2];

            StringTokenizer st;
            for (int k = 0; k < 2; k++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    data[k][i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i < n + 2; i++) {
                dp[0][i] = data[0][i - 2] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = data[1][i - 2] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            result.append(Math.max(dp[0][n + 1], dp[1][n + 1])).append("\n");
        }

        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }
}
