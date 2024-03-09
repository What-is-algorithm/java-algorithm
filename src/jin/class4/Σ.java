package jin.class4;

// [G4] 13172. Σ

import java.io.*;
import java.util.*;

public class Σ {
    private static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long m = Long.parseLong(br.readLine());
        long result = 0;

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long b = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long g = gcd(a, b);
            b /= g;
            a /= g;
            result += a * f(b, MOD - 2) % MOD;
            result %= MOD;
        }

        System.out.println(result);
        br.close();
    }

    // 모듈러 거듭제곱 계산
    private static long f(long x, long y) {
        if (y == 1) return x % MOD;
        if (y % 2 == 1) return x * f(x, y - 1) % MOD;
        long p = f(x, y / 2);
        return p * p % MOD;
    }

    // 최대공약수 계산
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
