package jin.graph;

import java.io.*;
import java.util.*;

// [G5] 16928. 뱀과 사다리 게임
public class 뱀과사다리게임 {
    private static int N;
    private static int M;
    private static int[] dp = new int[101];
    private static Queue<Integer> que;
    private static Map<Integer, Integer> ladder;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        ladder = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ladder.put(s, e);
        }

        int result = bfs();
        System.out.println(result);
//        System.out.println(Arrays.toString(dp));
        br.close();
    }

    private static int bfs() {
        que = new LinkedList<>();
        que.add(1);

        while(!que.isEmpty()) {
            int curr = que.poll();

            if (curr == 100)
                return dp[curr];

            for (int i = 1; i <= 6; i++) {
                int next = curr + i;

                if (next > 100)
                    continue;

                if (ladder.containsKey(next))
                    next = ladder.get(next);

                if (dp[next] == 0) {
                    dp[next] = dp[curr] + 1;
                    que.add(next);
                }
            }
        }
        return 0;
    }
}
