package yelim.bigO;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigO_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        int a1 = Integer.parseInt(a[0]); // 7
        int a0 = Integer.parseInt(a[1]); // 7

        int c = Integer.parseInt(br.readLine()); // 8
        int n0 = Integer.parseInt(br.readLine()); // 1

        // O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
        // f(n) = a1n + a0, g(n) = n
        // 모든 n >= 1에 대해 7n + 7 <= 8 * n인 양의 상수 c와 n0가 존재한다.
        // n=1일 때, 14 <= 8 -> X

        int fn = a1 * n0 + a0;
        int cgn = c * n0;

        // a1 <= c
        // 예외 상황으로
        // f(n) = 5n - 2, c = 3, n0 = 1
        // f(1) = 3 <= c x g(1) -> 3 <= 3 -> 만족
        // f(n) = 5n - 2, c = 3, n0 = 2
        // f(1) = 8 <= c x g(2) -> 8 <= 6 -> 만족 X
        // f(n) = 5n - 2에서 5와 c = 3
        // a1 <= c 이어야 한다.
        if(fn <= cgn && a1 <= c) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
