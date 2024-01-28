package jin.class4;

import java.io.*;
import java.util.StringTokenizer;

// [S1] 1629. 곱셈
public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = customPow(A, B, C);
        System.out.println(result % C);

        br.close();
    }

    private static long customPow(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }

        long result = customPow(a, b / 2, c);

        if (b % 2 == 0) return result * result % c;
        else return (result * result % c) * a % c;
    }
}
