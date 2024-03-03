package jin.class4;

import java.io.*;
import java.util.*;

// [G5] 2096. 내려가기

public class 내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxDp = new int[N + 1][3];
        int[][] minDp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            maxDp[i][0] = arr[i - 1][0] + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = arr[i - 1][1] + Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2]));
            maxDp[i][2] = arr[i - 1][2] + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);

            minDp[i][0] = arr[i - 1][0] + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = arr[i - 1][1] + Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2]));
            minDp[i][2] = arr[i - 1][2] + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }

        int maxNum = Math.max(maxDp[N][0], Math.max(maxDp[N][1], maxDp[N][2]));
        int minNum = Math.min(minDp[N][0], Math.min(minDp[N][1], minDp[N][2]));
        System.out.printf("%d %d", maxNum, minNum);
    }
}
