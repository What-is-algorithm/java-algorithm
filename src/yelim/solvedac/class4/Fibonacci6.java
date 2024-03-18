package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci6 {
    final static long MOD = 1000000007;
    static long[][] origin = {{1 , 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 피보나치 수 = Fn = Fn-1 + Fn-2
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 ...
        // n번째 피보나치 수를 1,000,000,007로 나눈 나머지 출력
        // 1 <= n <= 1,000,000,000,000,000,000

        // 피보나치 점화식, Fn = Fn-1 + Fn-2을 행렬로 만들기
        // -> Fn+2 = | 1  1 | | Fn+1 |
        //                    | Fn   |
        // Fn+1 = Fn+1 + 0 * Fn
        // -> Fn+1 = | 1  0 | | Fn+1 |
        //                    | Fn   |
        // 위 두 식을 결합하면
        // | Fn+2 | = | 1  1 | | Fn+1 |
        // | Fn+1 |   | 1  0 | | Fn   |
        //     V         V         V     이 식은 일반화하면
        //   Un+1   =    A    *    Un
        //    U1    =    A    *    U0
        // -> U0 = | 1 |
        //         | 0 | (F0 = 0, F1 = 1)
        //    U2 = A * U1 = A (A * U0) = A^2 * U0
        //    U3 = A * U2 = A (A * U1) = A * (A (A * U0)) = A^3 * U0
        // -> Un = A^n * U0
        //                    n
        // | Fn+1 | = | 1  1 |  | 1 |
        // |  Fn  |   | 1  0 |  | 0 |

        //                n
        //       | 1   1 |    | F(n+1)  F(n)  |
        // A^n = |       |  = |               |
        //       | 1   0 |    |  F(n)  F(n-1) |

        long[][] A = {{1, 1}, {1, 0}};
        long N = Long.parseLong(br.readLine());

        System.out.println(pow(A, N - 1)[0][0]);
    }

    static long[][] pow(long[][] A, long exp) {
        if(exp == 1 || exp == 0) return A;

        // 지수를 절반으로 분할하여 재귀호출
        long[][] half = pow(A, exp / 2);

        // 하위 재구에서 엍은 행렬 제곱
        half = multifly(half, half);

        if(exp % 2 == 1L) {
            half = multifly(half, origin);
        }

        return half;
    }

    static long[][] multifly(long[][] o1, long[][] o2) {
        long[][] result = new long[2][2];

        result[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        result[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        result[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        result[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

        return result;
    }
}
// https://st-lab.tistory.com/252