package jin.class4_2;

import java.io.*;
import java.util.*;

public class 파이프옮기기1_17070 {

    static int N;
    static int[][] data;
    static long[][][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1][3]; // 0: 가로, 1: 세로, 2: 대각선

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1; // 초기 파이프 위치 설정 (가로로 놓여 있음)

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (data[i][j] == 1) continue;

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로로 이동
                if (i > 1) dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]; // 세로로 이동

                if (i > 1 && data[i - 1][j] == 0 && data[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]; // 대각선 이동
                }
            }
        }

        long result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(result);
    }
}

