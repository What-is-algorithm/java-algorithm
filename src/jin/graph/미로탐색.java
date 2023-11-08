package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [S1] 2178. 미로 탐색
public class 미로탐색 {
    private static int N;
    private static int M;
    private static int[][] graph;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < line.length(); j++) {
                graph[i+1][j+1] = line.charAt(j) - '0';
            }
        }

        /*for (int[] test : graph) {
            System.out.println(Arrays.toString(test));
        }*/

        // (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때
        bfs();

        // 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
        System.out.println(graph[N][M]);

        br.close();
    }

    private static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 1));

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!que.isEmpty()) {
            Node node = que.poll();

            for (int d = 0; d < 4; d++) {
                int nx = node.getX() + dx[d];
                int ny = node.getY() + dy[d];

                if (nx < 1 || ny < 1 || nx > M || ny > N)
                    continue;

                if (graph[ny][nx] == 1) {
                    graph[ny][nx] = graph[node.getY()][node.getX()] + 1;
                    que.add(new Node(nx, ny));
                }
            }
        }
    }
}
