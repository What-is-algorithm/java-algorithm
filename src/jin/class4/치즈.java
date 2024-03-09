package jin.class4;

import java.io.*;
import java.util.*;

// [G3] 2638. 치즈

public class 치즈 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = getTime(arr);
        System.out.println(result);
        br.close();
    }

    private static int getTime(int[][] arr) {
        // while
        int time = 0;
        int n = arr.length;
        int m = arr[0].length;
        while (true) {
            boolean[][] visited = new boolean[n][m];
            markOutSideAir(visited);
            // 1. getCheese() -> list -> 0 ? break : 코드 실행
            List<int[]> meltCheeseList = getRemovedCheese(arr, visited);

            if (meltCheeseList.isEmpty()) break;
            time++;
            // 2. removeCheese()
            removeCheese(arr, meltCheeseList);
        }

        return time;
    }

    private static void markOutSideAir(boolean[][] visited) {
        Queue<int[]> que = new LinkedList<>();
        visited[0][0] = true;
        que.add(new int[]{0, 0});

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int y = curr[0];
            int x = curr[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx] || arr[ny][nx] != 0) continue;

                visited[ny][nx] = true;
                que.add(new int[]{ny, nx});
            }
        }
    }

    private static List<int[]> getRemovedCheese(int[][] arr, boolean[][] visited) {
        List<int[]> removedList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && isOutSideAir(i, j, visited)) {
                    removedList.add(new int[]{i, j});
                }
            }
        }

        return removedList;
    }

    private static boolean isOutSideAir(int y, int x, boolean[][] visited) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M || !visited[ny][nx]) continue;
            cnt++;
        }

        return cnt >= 2;
    }

    private static void removeCheese(int[][] arr, List<int[]> list) {
        for (int[] data : list) {
            int i = data[0], j = data[1];
            arr[i][j] = 0;
        }
    }
}

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 0 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
*/
