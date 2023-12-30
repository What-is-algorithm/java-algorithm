package jin.class4;

import java.io.*;
import java.util.*;

// [S1] 1932. 정수 삼각형
// dp
public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           final int N = Integer.parseInt(br.readLine());
           int[][] data = new int[N][N];

           for (int i = 0; i < N; i++) {
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               for (int j = 0; j <= i; j++) {
                   data[i][j] = Integer.parseInt(st.nextToken());
               }
           }

           for (int i = 1; i < N; i++) {
               for (int j = 0; j <= i; j++) {
                   if (j == 0) {
                       data[i][j] += data[i-1][j];
                       continue;
                   }
                   data[i][j] += Math.max(data[i-1][j], data[i-1][j-1]);
               }
           }

           int result = 0;
           for (int j = 0; j < N; j++) {
               result = Math.max(result, data[N-1][j]);
           }

           System.out.println(result);
    }
}
