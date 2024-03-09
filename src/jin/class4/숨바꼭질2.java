package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 12851. 숨바꼭질 2

public class 숨바꼭질2 {

    static int N, K;
    static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] visited = new int[MAX];
        Arrays.fill(visited, -1);
        int[] count = new int[MAX];
        bfs(N, K, visited, count);

        System.out.println(visited[K]);
        System.out.println(count[K]);
        br.close();
    }

    private static void bfs(int start, int end, int[] visited, int[] count) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = 0;
        count[start] = 1;

        while (!que.isEmpty()) {
            int curr = que.poll();

            for (int next : new int[]{curr - 1, curr + 1, curr * 2}) {
                if (0 <= next && next < MAX) {
                    if (visited[next] == -1) {
                        visited[next] = visited[curr] + 1;
                        count[next] = count[curr];
                        que.add(next);
                    } else if (visited[next] == visited[curr] + 1) {
                        count[next] += count[curr];
                    }
                }
            }
        }
    }
}
