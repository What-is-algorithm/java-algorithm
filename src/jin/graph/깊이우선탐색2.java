package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// [S2] 24480. 알고리즘 수업 - 깊이 우선 탐색 2
// 이중리스트 -> 외부 리스트의 인덱스 = 노드, 내부 리스트의 데이터들 = 해당 노드와 연결되어 있는 노드들
// i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다 -> 방문확인과 순서를 담을 sequence
// 내림차순
// dfs -> 1. 방문 했으니 해당 인덱스의 순서 저장 2. 반복문을 통해 해당 노드와 연결된 노드들이 방문한 적이 없으면 dfs 실행
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
