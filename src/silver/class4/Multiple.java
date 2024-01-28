package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiple {
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a, b));
        br.close();
    }

    private static long pow(long a, int b) {
        if (b == 1) {
            return a % c;
        }

        long tmp = pow(a, b / 2);

        if (b % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }
        return tmp * tmp % c;
    }
}
