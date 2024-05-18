package jin.class4_2;

import java.util.*;
import java.io.*;

public class 행렬제곱_10830 {
    static final long MOD = 1_000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[][] A = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }
        br.close();

        long[][] result = power(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static long[][] power(long[][] a, long b) {
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) {
            result[i][i] = 1;
        }

        while (b > 0) {
            if (b % 2 == 1) {
                result = multiply(result, a);
            }
            b /= 2;
            a = multiply(a, a);
        }

        return result;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}
