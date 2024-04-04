package jin.class4_2;

import java.io.*;
import java.util.*;

public class 구간합구하기5_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][N];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = data[i - 1][j - 1] + (dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int result = dp[y2][x2] - (dp[y2][x1 - 1] + dp[y1 - 1][x2] - dp[y1 - 1][x1 - 1]);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }
}
