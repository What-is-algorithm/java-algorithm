package yelim.solvedac.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 증가한 경우만 숫자를 세기
        // 증가한 숫자를 dp 배열에 반영
        // 1 <= N <= 1000

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] seq = new int[N+1];

        String[] input = br.readLine().split(" ");
        for(int i=1;i <= N;i++) {
            seq[i] = Integer.parseInt(input[i-1]);
            dp[i] = 1;
        }

        int max = 1;
        for(int j=1;j <= N;j++) {
            for(int k=1;k < j;k++) { // 이전 수들과 계속 비교하면서
                if(seq[j] > seq[k]) { // 이전 수보다 기준 수가 크다면 기준 수의 dp를 증가
                    dp[j] = Math.max(dp[j], dp[k]+1);
                }
            }
            max = Math.max(max, dp[j]);
        }

        System.out.println(max);
    }
}
