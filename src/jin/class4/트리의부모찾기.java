package jin.class4;

// [S2] 11725. 트리의 부모 찾기
import java.io.*;
import java.util.*;
public class 트리의부모찾기 {
    // 1이 루트 로드 -> 이 곳을 기준으로 탐색 시작하자
    // 루트 노드를 담을 배열
    // 각 노드들이 서로 연결되어 있는 이중 리스트
    // 방문 확인용 배열
    // bfs 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        StringTokenizer st;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        parents = bfs(graph, visited, parents, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    private static int[] bfs(List<List<Integer>> graph, boolean[] visited, int[] parents, int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int curr = que.poll();
            visited[curr] = true;
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    parents[next] = curr;
                    que.add(next);
                }
            }
        }

        return parents;
    }
}
