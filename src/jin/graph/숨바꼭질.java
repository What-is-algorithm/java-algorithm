package jin.graph;

import java.io.*;
import java.util.*;

// [S1] 1697. 숨바꼭질
public class 숨바꼭질 {
    private static int N;
    private static int K;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[100001];
        Arrays.fill(dp, -1);
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        dp[N] = 0;
        que.add(N);

        while (true) {
            int curr = que.poll();
            if (curr == K) {
                return dp[K];
            }

            int[] nextIdxs = new int[] { curr - 1, curr + 1, curr * 2 };
            for (int next : nextIdxs) {
                if (next >= 0 && next <= 100000 && dp[next] == -1) {
                    dp[next] = dp[curr] + 1;
                    que.add(next);

                }
            }
        }
    }
}
