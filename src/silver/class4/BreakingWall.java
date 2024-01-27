package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakingWall {
    private static int n, m;
    private static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] board;
    private static int[][][] visited;
//    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i ++) {
            String row = br.readLine();
            for (int j = 0; j < m; j ++) {
                board[i][j] = Integer.valueOf(row.charAt(j) - '0'); // 어쩌면 처음 배열 초기화를 진행했을 때, 어차피 기본으로 0으로 초기화가 되니까 1일 경우만 넣는 것도 나쁘지 않을지도?
            }
        }

//        for (int[] ints : board) {
//            System.out.println(Arrays.toString(ints));
//        }

        // 벽을 부수지 않은 경우 -> 벽을 1번 부수면서 이동 가능 + 벽 없는 곳 이동 가능
        // 벽을 부수고 탐색하는 경우 -> 벽이 없는 곳만 이동 가능
        // Todo 벽이라면 -> 벽을 부순 적 없다면 -> 부수고 이동 / 부순 적 있다면 -> 안 부수고 이동
        // Todo 벽이 아니라면 -> 이동
        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        visited = new int[2][n][m]; // Todo visited : 최단 거리의 값

        Queue<int[]> queue = new LinkedList<>(); // Todo 큐 : 방문할 인접 노드
        queue.offer(new int[] {0, 0, 0}); // 방문할 원점을 큐에 삽입
        visited[0][0][0] = 1; // 원점 방문 처리

        while (!queue.isEmpty()) { // 큐가 빌 때까지 = 방문할 곳이 없을 때까지
            int[] node = queue.poll(); // ex. 첫 번째, 원점을 큐에서 꺼냄
            int z = node[0]; // 벽을 안 부수거나 : 0, 벽을 부수거나 : 1
            int x = node[1]; // 행
            int y = node[2]; // 열

            // Todo for <-> while
            // Todo for문은 얼만큼 순회할지를 아는 반면에, while문은 알 수 없기 때문에..
            // Todo while문이 "언제 종료될지"를 미리 알려주고 시작하는게 좋음
            // Todo 즉, 탈출 조건을 미리 알려주는게 무한 루프가 아닌지를 판단할 겸 + 가독성을 위해서 현 시점에 선언
            // Todo 단, 구조를 다 알고 해당 메서드(= bfs())를 설계할 때 미리 선언할 수 있음
            if (x == n - 1 && y == m - 1) { // visited[0][0][0] = (0, 0)으로 시작했기 때문에, -1을 진행
                return visited[z][x][y];
            }

            int distance = 4;
            for (int i = 0; i < distance; i ++) {
                int nx = x + dx[i]; // 상하
                int ny = y + dy[i]; // 좌우

                if (nx >= n || ny >= m || nx < 0 || ny < 0) { // 좌표를 벗어났을 때
                    continue;
                }

                // 아니 내가 하고자 하는게 모야.
                // 벽을 부수지 않은 경우, 벽을 1번 부수면서 이동 가능 + 벽 없는 곳 이동 가능 <- 이건 이제 모르겠음 근데
                if (board[nx][ny] == 0 && visited[z][nx][ny] == 0) { // "벽이 아니라면"
//                    if (visited[z][nx][ny] == 0) { // 그냥 가면 되는 거 아님? -> 아, "방문한 적이 없다면"
                        visited[z][nx][ny] = visited[z][x][y] + 1; // @@@가고자 하는 위치 = 현재 위치 + 1@@@
                        queue.offer(new int[] {z, nx, ny});

//                        if (nx == n - 1 && ny == m - 1) { // 아 여긴 답 안 보려고 했는데 실수로 -1인거 봐버렸어 ㅜ
//                            return visited[z][nx][ny];
//                        }


                    continue;
//                    System.out.printf("벽이 없을 경우 -> z = %d, x = %d, y = %d \n", visited[z][nx][ny], nx, ny);
                } if (board[nx][ny] == 1 && z == 0) { // && visited[z][nx][ny] == 0) { // 벽이라면
//                    if (z == 0) { // 벽을 부순 적이 없다면 -> visited[0][nx][ny] == 0 ?? 아 어떻게 표현하쥐요..? -> 그냥 w == 0
//                        if (visited[z][nx][ny] == 0) { // 방문한 적이 없다면
                            visited[1][nx][ny] = visited[0][x][y] + 1; // (1) 방문을 하고, 거리를 업데이트
                            queue.offer(new int[]{1, nx, ny}); // (2) 방금 방문을 한 위치에서 다시 상/하/좌/우 이동을 해야하므로 큐에 삽입
                        }

//                        if (nx == n - 1 && ny == m - 1) {
//                            return visited[z][nx][ny];
//                        }
                     // Todo 벽인데, 벽을 부순 경험이 있다면 -> 해당 루트는 더이상 고려하지 않음

//                    System.out.printf("벽이 있을 경우 -> z = %d, x = %d, y = %d \n", visited[z][nx][ny], nx, ny);
                }
            }


        return -1;
        // return visited[z][nx][ny] 를 돌려줘야 하는데 지역변수라 소실되었어~~ 어떻게 돌려주지?
    }
}
