package jin.graph;

import java.io.*;
import java.util.*;

// [G5] 7576. 토마토
public class 토마토 {
    private static int N;
    private static int M;
    private static int[][] graph;
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static Queue<Move> que;

    static class Move {
        private int y;
        private int x;

        public Move(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    que.add(new Move(i, j));
                }
            }
        }

        int day = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
        }

        System.out.println(day);
    }

    private static int bfs() {
        // 익은 토마토를 만나기 전을 -1로 해야 처음 만났을 때 날짜가 0으로 가능
        int cnt = -1;

        while (!que.isEmpty()) {
            // for (int i = 0; i < que.size(); i++) -> 이 방식으로 하면 que에서 1개씩 값을 빼기 때문에 크기가 계속
            // 변해서 의도와 달라진다.
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Move node = que.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = node.y + dy[d];
                    int nx = node.x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                        continue;
                    }

                    if (graph[ny][nx] == 0) {
                        graph[ny][nx] = 1;
                        que.add(new Move(ny, nx));
                    }
                }
            }
            cnt++;
        }

        return cnt;
    }
}
