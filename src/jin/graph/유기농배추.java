package jin.graph;

import java.io.*;
import java.util.*;

// [S2] 1012. 유기농 배추
public class 유기농배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int q = 0; q < T; q++) {
            st = new StringTokenizer(br.readLine(), " ");
            final int M = Integer.parseInt(st.nextToken());
            final int N = Integer.parseInt(st.nextToken());
            final int K = Integer.parseInt(st.nextToken());

            int[][] graph = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int cnt = 0;

            for (int w = 0; w < K; w++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, graph, visited);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int y, int x, int[][] graph, boolean[][] visited) {
        if (y < 0 || x < 0 || y >= graph.length || x >= graph[0].length)
            return;

        if (graph[y][x] != 1 || visited[y][x])
            return;

        visited[y][x] = true;
        dfs(y + 1, x, graph, visited);
        dfs(y, x + 1, graph, visited);
        dfs(y - 1, x, graph, visited);
        dfs(y, x - 1, graph, visited);
    }

}