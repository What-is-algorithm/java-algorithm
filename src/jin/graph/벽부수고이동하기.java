package jin.graph;

import java.util.*;
import java.io.*;

// [G3] 2206. 벽 부수고 이동하기
// 이동 조건 2개 -> 1. 벽을 부수고 이동할 것인가? (벽 부쉈는지 확인하기) 2. 벽이 없는 곳을 이동할 것인가?
// 방문 처리할 때 조건 2개 -> 벽 부수고 이동했는지? 벽 부수지 않고 이동했는지?
// visited -> [행][열][벽 부수지 않은 상태 기록, 벽 부순 후의 상태 기록]
public class 벽부수고이동하기 {
    static int N;
    static int M;
    static int[][] graph;
    static Queue<Node> que;
    static int[][][] visited;


    static class Node {
        int y;
        int x;
        int z; // 0, 1 둘중 한개 -> 벽 깼으면 1

        public Node (int y, int x, int z){
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

//        for (int[] g : graph) {
//            System.out.println(Arrays.toString(g));
//        }

        int result = bfs();

        if (result == 0)
            result = -1;

        System.out.println(result);
        br.close();
    }

    private static int bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        que = new LinkedList<>();
        que.add(new Node(0, 0, 0));
        visited[0][0][0] = 1;
        while(!que.isEmpty()) {
            Node node = que.poll();

            if (node.y == N-1 && node.x == M-1) {
                return visited[node.y][node.x][node.z];
            }

            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                    continue;

                if (graph[ny][nx] == 1 && node.z == 0) {
                    visited[ny][nx][1] = visited[node.y][node.x][0] + 1;
                    que.add(new Node(ny, nx, 1));
                }

                if (graph[ny][nx] == 0 && visited[ny][nx][node.z] == 0) {
                    visited[ny][nx][node.z] = visited[node.y][node.x][node.z] + 1;
                    que.add(new Node(ny, nx, node.z));
                }
            }
        }
        return -1;
    }
}
