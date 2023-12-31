package yelim.solvedac.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RGBstreet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 각 집을 칠하는 최소 비용을 찾아 구하는 것이 아닌 모든 경로의 경우의 수 찾아야 한다.
        // 1번 빨 , 1번 초 , 1번 파
        // 2번 빨 += min(1번 초 , 1번 파) , 2번 초 += min(1번 빨 , 1번 파) , 2번 파 += min(1번 빨 , 1번 초)
        // 3번 빨 += min(2번 초 , 2번 파) , 3번 초 += min(2번 빨 , 2번 파) , 3번 파 += min(2번 빨 , 2번 초)
        // N번 빨 += min(N-1 초, N-1 파) , N번 초 += min(N-1 빨, N-1 파) , N번 파 += min(N-1 빨, N-1 초)
        // 2 <= N <= 1000

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        String[] first = br.readLine().split(" ");
        dp[1][0] = Integer.parseInt(first[0]);
        dp[1][1] = Integer.parseInt(first[1]);
        dp[1][2] = Integer.parseInt(first[2]);

        for (int i = 2; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            dp[i][0] = Integer.parseInt(input[0]);
            dp[i][1] = Integer.parseInt(input[1]);
            dp[i][2] = Integer.parseInt(input[2]);

            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
