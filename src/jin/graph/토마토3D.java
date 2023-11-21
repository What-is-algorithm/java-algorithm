package jin.graph;

import java.io.*;
import java.util.*;

// [G5] 7569. 토마토
public class 토마토3D {
    private static int M;
    private static int N;
    private static int H;
    private static int[][][] graph;
    private static Queue<Node> que;

    static class Node {
        private int y;
        private int x;
        private int h;

        public Node(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    graph[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

//        for (int[][] g1 : graph) {
//            for (int[] g2 : g1) {
//                System.out.println(Arrays.toString(g2));
//            }
//        }

        que = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[k][i][j] == 1) {
                        que.add(new Node(k, i, j));
                    }
                }
            }
        }

        int day = bfs();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[k][i][j] == 0) {
                        day = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(day);
    }

    private static int bfs() {
        int cnt = -1;
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};

        while(!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node curr = que.poll();
                for (int d = 0; d < 6; d++) {
                    int nh = curr.h + dh[d];
                    int ny = curr.y + dy[d];
                    int nx = curr.x + dx[d];

                    if (nx < 0 || ny < 0 || nh < 0 || nx >= M || ny >= N || nh >= H)
                        continue;

                    if (graph[nh][ny][nx] == 0) {
                        graph[nh][ny][nx] = 1;
                        que.add(new Node(nh, ny, nx));
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
