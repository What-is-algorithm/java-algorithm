package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sigma {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 주사위는 기댓값이 있는데 기댓값 합 구하기
        // 기댓값 합이 기약 분수 X -> 해당 값을 출력
        // 기댓값 합이 기약 분수 O -> 분자 X 분모의 역원(페르마 소정리) mod 1000000007
        // ex) 기댓값이 7 / 3이 나오면 M개의 주사위 기댓값 합이 7 / 3이고 기약 분수라서
        //     (7 * 3^1000000005) mod 1000000007 = 333333338
        // 주사위 수 M
        int M = Integer.parseInt(br.readLine());
        // 분모 N, 분자 S
        long N = 1, S = 0;

        // 기댓값 합 구하기
        for(int i = 0; i < M; i++) {
            String[] ns = br.readLine().split(" ");
            int n = Integer.parseInt(ns[0]);
            int s = Integer.parseInt(ns[1]);
            // 각 분모와 분자를 통분하여 계산
            S = s * N + S * n;
            N *= n;
            // 모듈러 산술로 인하여 나머지 계산
            S %= MOD;
            N %= MOD;
        }

        // 기약 분수일 때
        if(S % N != 0) {
            System.out.println((search(N, MOD-2) * S) % MOD + "");
        } else { // 기약 분수가 아닐 때
            System.out.println(S / N + "");
        }
        br.close();
    }

    static long search(long N, int index) {
        if(index == 1) {
            return N;
        }

        long temp = search(N, index / 2);
        if(index % 2 == 1) {
            return temp * temp % MOD * N % MOD;
        } else {
            return temp * temp % MOD;
        }
    }
}
// https://tussle.tistory.com/1002