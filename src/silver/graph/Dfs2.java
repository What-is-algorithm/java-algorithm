package silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Dfs2 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] result;
    public static int idx;

    // O(m log m) 또는 O(m log n)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 정점의 수 : n
        int m = Integer.parseInt(st.nextToken()); // 간선의 수 : m
        int r = Integer.parseInt(st.nextToken()); // 시작 정점 : r

        /*
         * [[]]
         * [[], []]
         * [[], [], []]
         * [[], [], [], []]
         * [[], [], [], [], []]
         * [[], [], [], [], [], []]
         */

        // 1. 그래프 초기화
        // O(n)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        /*
         * [[], [4], [], [], [1], []]
         * [[], [4, 2], [1], [], [1], []]
         * [[], [4, 2], [1, 3], [2], [1], []]
         * [[], [4, 2], [1, 3, 4], [2], [1, 2], []]
         * [[], [4, 2], [1, 3, 4], [2, 4], [1, 2, 3], []]
         */

        // 2. 인접한 정점 정보 추가
        // O(m)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 양방향(= 무방향)
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        /*
         * [[], [4, 2], [4, 3, 1], [4, 2], [3, 2, 1], []]
         */

        // 3. 이웃 정점들을 내림차순으로 정렬
        // O(m log m) 또는 O(m log n)
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        // 4. 인덱스는 0부터 시작하지만, 정점은 1부터 존재하므로 +1
        visited = new boolean[n + 1];
        result = new int[n + 1];

        // 5. dfs
        dfs(r);

        // 6. 출력
        // O(n)
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;

        idx++;
        result[node] = idx;

        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode);
            }
        }
    }
}
