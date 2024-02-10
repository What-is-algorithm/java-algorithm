package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A, B, C <= 2,147,483,647
        String[] abc = br.readLine().split(" ");
        int A = Integer.parseInt(abc[0]); // 밑
        int B = Integer.parseInt(abc[1]); // 지수
        int C = Integer.parseInt(abc[2]);

        long result = NSquare(A, B, C);
        System.out.println(result % C);
        br.close();
    }

    static long NSquare(int a, int b, int c) {
        if(b == 0) {
            return 1;
        }

        long result = NSquare(a, b / 2, c);

        if(b % 2 == 0) {
            return result * result % c;
        }else {
            return (result * result % c) * a % c;
        }
// 왜 재귀 함수를 사용하면 시간 초과가 나는가...
//        if(b % 2 == 0) {
//            return NSquare(a, b / 2, c) * NSquare(a, b / 2, c) % c;
//        }else {
//            return (NSquare(a, b / 2, c) * NSquare(a, b / 2, c) % c) * a % c;
//        }
    }
    // 5 ^ 10 = 5^5 * 5^5
    // 5 ^ 5 = 5^2 * 5^2 * 5
    // 5 ^ 2 = 5^1 * 5^1
    // NSquare(5, 10) = NSquare(5, 5) * NSquare(5, 5) = ((5 * 5) * (5 * 5) * 5) * ((5 * 5) * (5 * 5) * 5)
    // NSquare(5, 5) = NSquare(5, 2) * NSquare(5, 2) * 5 = (5 * 5) * (5 * 5) * 5
    // NSquare(5, 2) = NSquare(5, 1) * NSquare(5, 1) = 5 * 5
    // NSquare(5, 1) = NSquare(5, 0) * NSquare(5, 0) * 5 = 1 * 1 * 5 = 5
}
