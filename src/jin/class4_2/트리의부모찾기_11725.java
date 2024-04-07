package jin.class4_2;

import java.io.*;
import java.util.*;

public class 트리의부모찾기_11725 {

    static int N;
    static int[] parents;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(p).add(c);
            graph.get(c).add(p);
        }

        bfs();

        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            result.append(parents[i]).append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()) {
            int curr = que.poll();

            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    parents[next] = curr;
                    que.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
