package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [S2] 24444. 알고리즘 수업 - 너비 우선 탐색 1
// 이중리스트 -> 외부 리스트의 인덱스 = 노드, 내부 리스트의 데이터들 = 해당 노드와 연결되어 있는 노드들
// i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다 -> 방문확인과 순서를 담을 sequence
// 오름차순
// bfs
// 1. 1번 부터 시작 -> 방문 체크(cnt=1) + 큐에 1번 노드 넣기
// 2. 큐에서 값을 가져와 다음 노드들 방문 체크 -> 방문한적 없는 노드에 ++cnt AND 큐에 넣기
public class 너비우선탐색1 {
    static List<List<Integer>> graph;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0], m = input[1], r = input[2];
        seq = new int[n+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]), e = Integer.parseInt(line[1]);
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

//        System.out.println(graph);

        bfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(seq[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        int cnt = 1;
        seq[start] = cnt;
        que.add(start);

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
