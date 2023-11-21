package silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakingWallAndMoving {
    private static int n, m;
    private static int[][] map;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        // 2. 입력
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();

            for (int j = 0; j < map[i].length; j++) {
                int num = str.charAt(j) - '0';
                if (num == 1) {
                    map[i][j] = num;
                }
            }
        }

        // 3. 출발지와 목적지가 같을 경우, 종료
        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0); // main() 종료
        }

        // 4. 탐색 및 출력
        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        // 방문을 체크하는 3차원 배열
        // [0, n, m] : 벽 안부수고 지나가는 방문노드 경로
        // [1, n, m] : 벽 부수고 지나가는 방문노드 경로
        int[][][] visited = new int[2][n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (true) {
            int[] node = q.poll();
            int w = node[0];
            int x = node[1];
            int y = node[2];
            int direction = 4;

            for (int i = 0; i < direction; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= n || nx < 0 || ny >= m || ny < 0) {
                    continue;
                }

                if (map[nx][ny] == 0) { // 벽이 아닐 때
                    if (visited[w][nx][ny] == 0) {
                        q.offer(new int[]{w, nx, ny});
                        visited[w][nx][ny] = visited[w][x][y] + 1;

                        if (nx == n - 1 && ny == m - 1) {
                            return visited[w][nx][ny]; // 뱀과 사다리 게임과 유사한 탈출 조건
                        }
                    }
                } else { // 벽일 때
                    // 1. 이미 벽을 부순 전적이 있다면 pass
                    // 2. 벽을 부순 전적이 없다면, 벽을 부수고 진행
                    if (w == 0) { //
                        if (visited[1][nx][ny] == 0) {
                            q.offer(new int[]{1, nx, ny});
                            visited[1][nx][ny] = visited[0][x][y] + 1;

                            if (nx == n - 1 && ny == m - 1) {
                                return visited[1][nx][ny];
                            }
                        }
                    }
                }
            }

            if (q.isEmpty()) {
                return -1;
            }
        }
    }
}
