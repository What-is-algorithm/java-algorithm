package jin.class4_2;

// [S1] 1932. 정수 삼각형

import java.io.*;
import java.util.*;

public class 정수삼각형_1932 {

    static int N;
    static int[][] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j <= i; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                data[i][j] += j == 0 ? data[i - 1][j] : Math.max(data[i - 1][j], data[i - 1][j - 1]);
            }
        }

        int result = 0;
        for (int j = 0; j < N; j++) {
            result = Math.max(result, data[N - 1][j]);
        }
        System.out.println(result);
    }
}
