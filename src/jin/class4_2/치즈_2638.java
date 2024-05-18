package jin.class4_2;

import java.io.*;
import java.util.*;

public class 치즈_2638 {

    static int N, M;
    static int[][] data;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = getTime();
        System.out.println(result);
        br.close();
    }

    private static int getTime() {
        int time = 0;
        while (true) {
            boolean[][] visited = new boolean[N][M];
            markOutSideAir(visited);
            List<int[]> meltCheeseList = getMeltCheeseList(visited);

            if (meltCheeseList.isEmpty()) break;
            time++;
            removeCheese(meltCheeseList);
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
                if (visited[ny][nx] || data[ny][nx] != 0) continue;

                visited[ny][nx] = true;
                que.add(new int[]{ny, nx});
            }
        }
    }

    private static List<int[]> getMeltCheeseList(boolean[][] visited) {
        List<int[]> meltingCheeseList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 1 && isOutSideAir(i, j, visited)) {
                    meltingCheeseList.add(new int[]{i, j});
                }
            }
        }

        return meltingCheeseList;
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

    private static void removeCheese(List<int[]> list) {
        for (int[] ints : list) {
            int i = ints[0], j = ints[1];
            data[i][j] = 0;
        }
    }
}
