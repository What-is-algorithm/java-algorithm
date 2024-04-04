package jin.class4_2;

import java.io.*;
import java.util.*;

public class 벽부수고이동하기_2206 {

    static int N, M;
    static int[][] data;
    static int[][][] visited; // [][][x, o]
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                data[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new int[N][M][2];
        int result = bfs();
        System.out.println(result);
        br.close();
    }

    private static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        while (!que.isEmpty()) {
            Node curr = que.poll();

            if (curr.y == N - 1 && curr.x == M - 1) return visited[curr.y][curr.x][curr.z];

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                if (data[ny][nx] == 0 && visited[ny][nx][curr.z] == 0) {
                    visited[ny][nx][curr.z] = visited[curr.y][curr.x][curr.z] + 1;
                    que.add(new Node(ny, nx, curr.z));
                    continue;
                }

                if (data[ny][nx] == 1 && curr.z == 0) {
                    visited[ny][nx][1] = visited[curr.y][curr.x][0] + 1;
                    que.add(new Node(ny, nx, 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int y, x, z;

        public Node(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }
}
