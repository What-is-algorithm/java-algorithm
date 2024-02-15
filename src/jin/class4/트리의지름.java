package jin.class4;

import java.io.*;
import java.util.*;

public class 트리의지름 {
    // [G2] 1167. 트리의 지름
    static class Node {
        int to, weight;

        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<List<Node>> graph;
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

                graph.get(idx).add(new Node(to, cost));
            }
        }

        // 임의의 노드에서 가장 먼 노드 찾기
        dfs(1, 0, new boolean[V + 1]);
        // 찾은 노드 부터 가장 먼 노드까지 거리 구하기
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

        for (Node next : graph.get(node)) {
            dfs(next.to, next.weight + distance, visited);
        }
    }
}
