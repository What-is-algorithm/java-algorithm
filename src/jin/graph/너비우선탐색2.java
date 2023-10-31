package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [S2] 24445. 알고리즘 수업 - 너비 우선 탐색 2
public class 너비우선탐색2 {
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
            graph.get(i).sort((o1, o2) -> o2 - o1);
        }

        bfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(seq[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        int cnt = 1;
        seq[start] = cnt;
        while (!que.isEmpty()) {
            int node = que.poll();

            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);
                if (seq[next] == 0) {
                    seq[next] = ++cnt;
                    que.add(next);
                }
            }
        }
    }
}
