package jin.class4;

// [G2] 11444. 피보나치 수 6 -> 미완성

import java.util.Scanner;

public class 피보나치수6 {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        // divide-conquer?
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        if (n == 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        long[][] arr = {{1L, 1L}, {1L, 0L}};
        long[][] result = power(arr, n - 1);
        System.out.println(result[0][0]);
        sc.close();
    }

    private static long[][] power(long[][] arr, long n) {
        if (n == 1) {
            return arr;
        }

        long[][] half = power(arr, n / 2);
        if (n % 2 == 0) {
            return multiply(half, half);
        }
        return multiply(multiply(half, half), arr);
    }

    private static long[][] multiply(long[][] arr1, long[][] arr2) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + arr1[i][k] * arr2[k][j]) % MOD;
                }
            }
        }

        return result;
    }
}
