package silver.graph;

import java.io.*;
import java.util.*;

public class DfsBfs {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수 : n
        int m = Integer.parseInt(st.nextToken()); // 간선의 수 : m
        int v = Integer.parseInt(st.nextToken()); // 시작 정점 : r

        // 1. 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        /*
         * [[], [2, 3, 4], [1, 4], [1, 4], [1, 2, 3]]
         */

        // 2. 이웃 정점들을 오름차순으로 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        // 3. 방문 유무 초기화
        visited = new boolean[n + 1];

        // 4. dfs
        dfs(v);
        sb.append('\n');

        // 5. 방문 유무 재초기화
        Arrays.fill(visited, false);

        // 6. bfs
        bfs(v);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");

        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");

            for (int adjNode : graph.get(node)) {
                if (!visited[adjNode]) {
                    queue.offer(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }
}
