package jin.class4_2;

import java.io.*;
import java.util.*;

public class 평범한배낭_12685 {

    static int N, K;
    static int[] weights;
    static int[] values;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weights = new int[N + 1];
        values = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());;
            values[i] = Integer.parseInt(st.nextToken());;
        }

        // dp[아이템 개수][물품의 무게] = 가치;
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (weights[i] <= w) {
                    // 물품이 i개 있을 때 모든 가치를 기록을 해두는 것.
                    // weights[i] <= w ==> 아이템의 각각의 무게
                    // 물품이 추가한다는 것은 가치를 비교할 때 -> 가치 비교는 이전의 같은 무게에 대한 가치 vs 현재 물품의 무게를 뺀 아이템(i-1) + 현재의 가치
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
            /*System.out.println("------");
            System.out.printf("w=%d, v=%d\n", weights[i], values[i]);
            for (int[] d : dp) {
                System.out.println(Arrays.toString(d));
            }*/
        }

        System.out.println(dp[N][K]);
    }
}
