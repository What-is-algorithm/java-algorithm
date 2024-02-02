package jin.class4;

import java.io.*;
import java.util.*;

// [S1] 9465. 스티커
public class 스티커 {
    // 두 개의 dp? 2행n열 -> 1행시작 dp, 2행 시작 dp
    // 그리디 인가벼
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int k = 0; k < N; k++) {
            int M = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][M];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }

            }

            int result = getMaxScore(arr);
            sb.append(result).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int getMaxScore(int[][] arr) {
        int len = arr[0].length;

        for (int i = 1; i < len; i++) {
            arr[0][i] += Math.max(arr[1][i - 1], (i >= 2) ? arr[1][i - 2] : 0);
            arr[1][i] += Math.max(arr[0][i - 1], (i >= 2) ? arr[0][i - 2] : 0);
        }
        /*
        애초에 배열을 arr[2][N+2]로 선언해서 다음과 같이 하는게 더 낫긴 하네
        for (int i = 2; i < len + 2; i++) {
            arr[0][i] += Math.max(arr[1][i - 1], arr[1][i - 2]);
            arr[1][i] += Math.max(arr[0][i - 1], arr[1][i - 2]);
        }*/

        return Math.max(arr[0][len - 1], arr[1][len - 1]);
    }
}
