package yelim.solvedac.class4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MatrixSquare {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기가 N*N인 행렬 A의 B 제곱 구하기 -> A^B의 각 원소를 1,000으로 나눈 나머지를 출력
        String[] nb = br.readLine().split(" ");
        // 행렬 크기 N (2 ≤ N ≤ 5), 0 <= 행렬의 각 원소 <= 1000
        N = Integer.parseInt(nb[0]);
        // B 제곱 (1 ≤ B ≤ 100,000,000,000) -> int X, long O
        long B = Long.parseLong(nb[1]);

        // B 제곱을 반으로 나누면서 분할 정복
        arr = new int[N][N];

        for(int i=0;i < N;i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0;j < N;j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    static int[][] divide(int[][] arr, long exp) {
        if(exp == 1L) { // 지수가 1일 때 arr을 반환
            return arr;
        }

        int[][] half = divide(arr, exp / 2);
        half = multifly(half, half);

        if(exp % 2 == 1L) { // 지수가 홀수라면 마지막에 arr^1을 곱하기
            half = multifly(half, arr);
        }

        return half;
    }

    static int[][] multifly(int[][] o1, int[][] o2) {
        int[][] result = new int[N][N];

        for(int i=0;i < N;i++) {
            for(int j=0;j < N;j++) {
                for(int k=0;k < N;k++) {
                    result[i][j] += o1[i][k] * o2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }
}
