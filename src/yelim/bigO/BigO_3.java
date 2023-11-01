package yelim.bigO;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigO_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주어진 알고리즘은 바깥 반복문에서 입력 크기만큼 반복하고
        // 안쪽 반복문에서도 입력 크기만큼 반복하여 배열에 인덱스로 접근(O(1))하여 연산
        // -> O(N^2)
        // 0 <= 입력 n =< 500000 -> 제곱할 경우, int 범위를 벗어날 수 있으므로 long
        long n = Long.parseLong(br.readLine());
        System.out.println(n * n);
        System.out.println(2);
    }
}
