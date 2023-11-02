package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// [S2] 24479. 알고리즘 수업 - 깊이 우선 탐색 1
// 이중리스트 -> 외부 리스트의 인덱스 = 노드, 내부 리스트의 데이터들 = 해당 노드와 연결되어 있는 노드들
// i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다 -> 방문확인과 순서를 담을 sequence
// 오름차순
// dfs -> 1. 방문 했으니 해당 인덱스의 순서 저장 2. 반복문을 통해 해당 노드와 연결된 노드들이 방문한 적이 없으면 dfs 실행
public class 깊이우선탐색1 {
    static int cnt = 1;
    static List<List<Integer>> graph;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // (5 ≤ N ≤ 100,000) | (1 ≤ M ≤ 200,000)
        int n = input[0], m = input[1], r = input[2];
        seq = new int[n+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        seq[r] = cnt;
        dfs(r);
        for (int i = 1; i <= n; i++) {
            System.out.println(seq[i]);
        }
    }

    private static void dfs(int start) {
        seq[start] = cnt;
        for(int node : graph.get(start)) {
            if (seq[node] == 0) {
                cnt++;
                dfs(node);
            }
        }
    }
}
