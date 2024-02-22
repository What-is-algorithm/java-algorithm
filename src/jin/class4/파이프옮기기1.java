package jin.class4;

import java.io.*;
import java.util.*;

// [G5] 17070. 파이프 옮기기 1

public class 파이프옮기기1 {
    // 우, 하, 우하 -> 우아하게
    // isValid(y, x) if (N - 1)
    // 가로 세로 대각선 판별..? dp [][][] good

    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N + 1][N + 1][3];

        for (int[][] ints : dp) {
            for (int[] arr : ints) {
                Arrays.fill(arr, -1);
            }
        }

        int result = movePipe(0, 1, 0, graph, dp);
        System.out.println(result);
        br.close();
    }

    // 0:가로, 1:세로, 2:대각선
    private static int movePipe(int y, int x, int dir, int[][] graph, int[][][] dp) {
        if (y == N - 1 && x == N -1) {
            return 1;
        }

        if (dp[y][x][dir] != -1) {
            return dp[y][x][dir];
        }

        int cnt = 0;

        // 가
        if (
                dir != 1 && x + 1 < N &&
                canMove(y, x + 1, graph)
        ) {
            cnt += movePipe(y, x + 1, 0, graph, dp);
        }
        // 세
        if (
                dir != 0 && y + 1 < N &&
                canMove(y + 1, x, graph)
        ) {
            cnt += movePipe(y + 1, x, 1, graph, dp);
        }
        // 대
        if (
                x + 1 < N && y + 1 < N &&
                canMove(y, x + 1, graph) &&
                canMove(y + 1, x, graph) &&
                canMove(y + 1, x + 1, graph)
        ) {
            cnt += movePipe(y + 1, x + 1, 2, graph, dp);
        }

        dp[y][x][dir] = cnt;
        return cnt;
    }

    private static boolean canMove(int y, int x, int[][] graph) {
        return y < N && x < N && graph[y][x] == 0;
    }
}
