package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 깊이우선탐색2 {
    static int cnt = 1;
    static List<List<Integer>> graph;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        seq = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), (o1, o2) -> o2 - o1);
        }

        seq[r] = cnt;
        dfs(r);
        for (int i = 1; i <= n; i++) {
            System.out.println(seq[i]);
        }
    }

    private static void dfs(int start) {
        seq[start] = cnt;
        for (int node : graph.get(start)) {
            if (seq[node] == 0) {
                cnt++;
                dfs(node);
            }
        }
    }

}
