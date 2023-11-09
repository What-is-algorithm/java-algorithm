package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// [S1] 7562. 나이트의 이동
public class 나이트의이동 {

    static class Node {
        private int y;
        private int x;

        public Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] end = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[][] graph = new int[l][l];
            bfs(graph, start[0], start[1], end[0], end[1]);
        }

        br.close();
    }

    private static void bfs(int[][] graph, int sy, int sx, int ey, int ex) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(sy,sx));

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        while(!que.isEmpty()) {
            Node curr = que.poll();
            if (curr.x == ex && curr.y == ey) {
                System.out.println(graph[ey][ex]);
                return;
            }

            for (int d = 0; d < 8; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= graph.length || nx >= graph[0].length)
                    continue;
                if (graph[ny][nx] == 0) {
                    graph[ny][nx] = graph[curr.y][curr.x] + 1;
                    que.add(new Node(ny, nx));
                }
            }
        }
    }
}
