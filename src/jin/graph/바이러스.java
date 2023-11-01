package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// [S3] 2606. 바이러스
public class 바이러스 {
    static int cnt = 0;
    static int[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());

        visited = new int[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        dfs(1);


        for (int i = 2; i <= N; i++) {
            if (visited[i] == 1)
                cnt++;
        }

//        System.out.println(Arrays.toString(visited));
        System.out.println(cnt);
    }

    private static void dfs(int start) {
        visited[start] = 1;
        for (int node: graph.get(start)) {
            if (visited[node] == 0) {
                dfs(node);
            }
        }
    }
}