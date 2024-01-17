package silver.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// Todo 이전 인덱스를 기억하고 있어야 하므로 "백트래킹"을 사용
// Todo 백트래킹 : 어떤 노드의 유망성을 판단, 유망하지 않다면 부모 노드로 돌아가 다른 자식 노드를 찾는 방법
// Todo N과 M이 주어지고, 중복되는 수를 제외한 모든 경우의 수를 탐색 -> 재귀 (DFS)
// Todo "1부터 N까지의 수 중 오름차순이면서 M의 길이까지 나열 가능한 수열"

// Todo "어떠한 수를 depth 즉 깊이로 두고 풀 것인가"

public class NAndM2 {
    private static StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n]; // 오름차순을 위한 방문 기록용
        arr = new int[m]; // 출력용 배열

        dfs(0, 0); // (depth : 출력 시 한 row 당 길이, start : 탐색할 노드)

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int val : arr) { // val : 출력할 노드(값)
                sb.append("val = ").append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) { // i : 탐색할 노드 ~ 끝까지 (ex. n = 4, 1 ~ 4 / 단, 현재는 코드 구조상 0부터 순회 중)
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;

                dfs(depth + 1, i + 1);

                visited[i] = false; // 노드 1을 기준으로 노드 2까지 탐색했을 경우, 노드 2를 기준으로 다시 탐색하기 위하여 초기화
            }
        }
    }
}