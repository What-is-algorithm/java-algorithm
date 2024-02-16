package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 1967. 트리의 지름
public class 트리의지름_1967 {

    static class Node {
        int idx, weight;

        public Node (int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static List<List<Node>> graph;
    static int farNode;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        dfs(1, 0, new boolean[N + 1]);
        dfs(farNode, 0, new boolean[N + 1]);
        System.out.println(result);
        br.close();
    }

    private static void dfs(int curr, int distance, boolean[] visited) {
        if (visited[curr]) return;

        visited[curr] = true;

        if (distance > result) {
            result = distance;
            farNode = curr;
        }

        for (Node next : graph.get(curr)) {
            dfs(next.idx, next.weight + distance, visited);
        }
    }
}
