package jin.class4;

import java.io.*;
import java.util.*;

// [G5] 12865. 평범한 배낭
public class 평범한배낭 {
    // O(N * K)
    // dp[N][K]
    // 입력 받기
    // 물건 정보 입력하기
    // DP 배열 초기화 하기 -> 각 무게에 대한 최대 가치 -> dp[N][K]
    // 최적해 찾기 -> 각 물건에 대해 현재 배낭 무게를 초과하지 않는 범위에서 최대 가치
    // 결과 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N];
        int[] values = new int[N];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }
}
