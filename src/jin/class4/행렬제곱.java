package jin.class4;

// [G4] 10830. 행렬 제곱

import java.io.*;
import java.util.StringTokenizer;

public class 행렬제곱 {

    static final long MOD = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[][] A = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] result = power(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    static long[][] power(long[][] a, long b) {
        int n = a.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
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
        int n = a.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}
