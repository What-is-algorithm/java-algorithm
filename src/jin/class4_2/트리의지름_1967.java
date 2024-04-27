package jin.class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1967 {
    static List<List<int[]>> graph;
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

            graph.get(from).add(new int[]{to, cost});
            graph.get(to).add(new int[]{from, cost});
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

        for (int[] next : graph.get(curr)) {
            dfs(next[0], distance + next[1], visited);
        }
    }
}
