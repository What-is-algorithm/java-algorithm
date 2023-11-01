package jin.graph;

import java.io.*;
import java.util.*;

// [S2] 1260. DFS와 BFS
public class DFS와BFS {
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());

        dfsVisited = new boolean[N+1];
        bfsVisited = new boolean[N+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        System.out.println();
        bfs(V);

    }

    private static void dfs(int start) {
        dfsVisited[start] = true;
        System.out.printf("%d ", start);
        for (int node : graph.get(start)) {
            if (!dfsVisited[node]) {
                dfs(node);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        bfsVisited[start] = true;
        que.add(start);

        while(!que.isEmpty()) {
            int node = que.poll();
            System.out.printf("%d ", node);
            for (int next : graph.get(node)) {
                if (!bfsVisited[next]) {
                    bfsVisited[next] = true;
                    que.add(next);
                }
            }
        }
    }
}
