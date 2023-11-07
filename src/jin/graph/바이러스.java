package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// [S3] 2606. 바이러스
// 이중리스트 -> 외부 리스트의 인덱스 = 노드, 내부 리스트의 데이터들 = 해당 노드와 연결되어 있는 노드들
// 1번을 시작으로 dfs
// 1. 탐색하며 방문한 곳을 배열을 통해 기록
// 2. 기록한 배열 중 방문한 곳의 개수를 합한다
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