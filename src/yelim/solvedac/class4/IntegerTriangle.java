package yelim.solvedac.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntegerTriangle {
    static int N;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new Integer[N][N];

        for(int i=0;i < N;i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0;j < i+1;j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 정수 삼각형의 마지막 줄의 수 누적합을 할 dp에 초기화
        for(int k=0;k < N;k++) {
            dp[N-1][k] = arr[N-1][k];
        }

        System.out.println(plus(0, 0));
    }

    static int plus(int depth, int idx) {
        // 정수 삼각형의 마지막 줄일 경우, 현재 위치의 dp 값 반환
        if(depth == N - 1) return dp[depth][idx];

        // 아직 탐색하지 않았다면 다음 행의 앙쪽 열 중 최대값 구하기
        if(dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(plus(depth + 1, idx), plus(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}
