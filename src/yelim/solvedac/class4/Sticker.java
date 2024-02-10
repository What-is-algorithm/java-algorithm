package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sticker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스티커를 선택하면 그 스티커의 상하좌우로 선택할 수 없다.
        // 스티커를 선택했을 때, 가능한 경우의 수는 대각선으로 가는 경우가 존재
        // (0,0) 스티커를 선택하면
        // -> 대각선에 있는 (1,1)로 가는 경우
        // -> 다른 옆 대각선에 있는 (1,2)로 가는 경우

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t < T;t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] score = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for(int i=0;i < 2;i++) {
                String[] sticker = br.readLine().split(" ");
                for(int j=1;j <= n;j++) {
                    score[i][j] = Integer.parseInt(sticker[j-1]);
                }
            }

            dp[0][1] = score[0][1];
            dp[1][1] = score[1][1];

            for(int k=2;k <= n;k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + score[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + score[1][k];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
