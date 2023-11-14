package yelim.graph;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Knight {
    static int l;
    static int x1, x2, y1, y2;
    static int[][] arr;
    static boolean[][] visited;
    // 두번 같은 방향으로 이동하고 한번 다른 방향으로 이동하는 모든 나이트의 움직임
    // 왼쪽 위 두 개, 왼쪽 아래 두 개, 오른쪽 위 두 개, 오른쪽 아래 두 개
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    // 움직인 칸 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i < testCase;i++) {
            // 체스판 크기
            l = Integer.parseInt(br.readLine());
            // 체스판 초기화
            arr = new int[l][l];
            // 방문 여부 배열 초기화
            visited = new boolean[l][l];

            // 나이트 시작 좌표
            String[] str1 = br.readLine().split(" ");
            x1 = Integer.parseInt(str1[0]);
            y1 = Integer.parseInt(str1[1]);

            // 나이트 도착 좌표
            String[] str2 = br.readLine().split(" ");
            x2 = Integer.parseInt(str2[0]);
            y2 = Integer.parseInt(str2[1]);

            bfs();

            sb.append(arr[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        // 시작 좌표 큐에 넣기
        q.add(new int[]{x1, y1});
        // 시작 좌표 방문 처리
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];

            // 나이트가 이동할 수 있는 8방향으로 탐색
            for (int i = 0; i < 8; i++) {
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                // 체스판 범위를 벗어나지 않는지
                if (ox >= 0 && oy >= 0 && ox < l && oy < l) {
                    // 방문하지 않았다면
                    if (!visited[ox][oy]) {
                        q.add(new int[]{ox, oy});
                        // 기존 좌표의 값인 움직인 수 + 1
                        arr[ox][oy] = arr[nx][ny] + 1;
                        visited[ox][oy] = true;
                    }
                }
            }
        }
    }
}
