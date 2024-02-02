package jin.class4;

import java.io.*;
import java.util.*;

// [G3] 2206. 벽 부수고 이동하기
public class 벽부수고이동하기 {
    // (1, 1)과 (N, M)은 항상 0이라고 가정하자.
    // 이동하는 방식 2개
    // 1. 벽을 부수지 않은 상태에서 이동
    // 2. 벽을 부순 후의 상태에서 이동
    static class Node {
        int y;
        int x;
        int z; // 0 or 1

        public Node (int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                data[i][j] = (str.charAt(j) - '0');
            }
        }

        int result = bfs(data);
        System.out.println(result);
        br.close();
    }

    private static int bfs(int[][] data) {
        int n = data.length;
        int m = data[0].length;
        int[][][] visited = new int[n][m][2];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        while (!que.isEmpty()) {
            Node curr = que.poll();
//            System.out.printf("y=%d, x=%d, broken=%d, data=%d\n", curr.y, curr.x, curr.z, visited[curr.y][curr.x][curr.z]);

            if ( (curr.y == n - 1) &&  (curr.x == m - 1) ) {
                return visited[curr.y][curr.x][curr.z];
            }

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n ) continue;

                // 848ms -> 792ms
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
}
