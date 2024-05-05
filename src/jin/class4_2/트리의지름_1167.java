package jin.class4_2;

import java.io.*;
import java.util.*;

public class 트리의지름_1167 {

    static List<List<int[]>> graph;
    static int farNode;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                graph.get(idx).add(new int[]{to, cost});
                graph.get(to).add(new int[]{idx, cost});
            }
        }

        dfs(1, 0, new boolean[V + 1]);
        dfs(farNode, 0, new boolean[V + 1]);

        System.out.println(result);
    }

    private static void dfs(int node, int distance, boolean[] visited) {
        if (visited[node]) return;

        visited[node] = true;

        if (distance > result) {
            result = distance;
            farNode = node;
        }

        for (int[] next : graph.get(node)) {
            dfs(next[0], distance + next[1], visited);
        }
    }
}
