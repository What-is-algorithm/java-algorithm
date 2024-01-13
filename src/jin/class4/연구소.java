package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 14502. 연구소
public class 연구소 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][M];
        List<int[]> walls = new ArrayList<>();
        List<int[]> virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽을 세울 수 있는 곳 필요
        // 바이러스만 모아두기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 0) {
                    walls.add(new int[] { i, j });
                } else if (data[i][j] == 2) {
                    virus.add(new int[] { i, j });
                }
            }
        }

        // 1. 모든 경우의 수를 알아야 하네? 벽 3개 짓고 난 후의 모든 경우의 수 nC3
        for (int i = 0; i < walls.size() - 2; i++) {
            for (int j = i + 1; j < walls.size() - 1; j++) {
                for (int k = j + 1; k < walls.size(); k++) {
                    int[] fir = walls.get(i);
                    int[] sec = walls.get(j);
                    int[] thr = walls.get(k);

                    // 2. 벽 3개 세우기
                    data[fir[0]][fir[1]] = 1;
                    data[sec[0]][sec[1]] = 1;
                    data[thr[0]][thr[1]] = 1;
                    // 3. 바이러스 퍼트리기
                    int[][] d = bfs(data, virus);
                    int safeZoneCnt = countSafeZone(d);
                    result = Math.max(result, safeZoneCnt);
                    // 4. 벽 3개 세우기 전으로 복귀
                    data[fir[0]][fir[1]] = 0;
                    data[sec[0]][sec[1]] = 0;
                    data[thr[0]][thr[1]] = 0;
                }
            }
        }

        System.out.println(result);
        br.close();
    }

    private static int[][] bfs(int[][] originalData, List<int[]> virus) {
        // deepcopy 필수
        int[][] data = Arrays.stream(originalData)
                .map(int[]::clone)
                .toArray(int[][]::new);
        Queue<int[]> que = new LinkedList<>(virus);
        int[] dx = new int[] { 1, 0, -1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int y = curr[0];
            int x = curr[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (nx < 0 || ny < 0 || ny >= data.length || nx >= data[0].length || data[ny][nx] != 0)
                    continue;

                data[ny][nx] = 2;
                que.add(new int[] { ny, nx });
            }
        }

        return data;
    }

    private static int countSafeZone(int[][] data) {
        int cnt = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
