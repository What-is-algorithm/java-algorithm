package jin.graph;

import java.io.*;
import java.util.*;

// [G4] 1707. 이분 그래프
// 방문했을 때 이전에 방문 했던 곳과 다른 노드를 가져야 한다.
// 노드값은 1, 2로 하자.
// 이전 노드 = 1 -> 다음 노드 = 2
// 이전 노드 = 2 -> 다음 노드 = 1
// if 이전 노드 == 다음 노드 -> return false;
public class 이분그래프 {
    private static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<List<Integer>> lst = new ArrayList<>();
            int[] visited = new int[v+1];
            for (int t = 0; t <= v; t++) {
                lst.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                lst.get(n1).add(n2);
                lst.get(n2).add(n1);
            }

            boolean rst = true;

            for (int i = 1; i <= v; i++) {
                if (visited[i] == 0) {
                    rst = bfs(i, lst, visited);
                    if (!rst) {
                        break;
                    }
                }
            }

            if (rst) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean bfs(int start, List<List<Integer>> lst, int[] visited) {
        que = new LinkedList<>();
        que.add(start);
        visited[start] = 1;

        while(!que.isEmpty()) {
            int curr = que.poll();
            for (int next : lst.get(curr)) {
                if (visited[next] == 0) {
                    que.add(next);
                    if (visited[curr] == 1)
                        visited[next] = 2;
                    if (visited[curr] == 2)
                        visited[next] = 1;
                }
                if (visited[curr] == visited[next])
                    return false;
            }
        }
        return true;
    }
}