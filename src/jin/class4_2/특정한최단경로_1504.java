package jin.class4_2;

import java.io.*;
import java.util.*;

public class 특정한최단경로_1504 {

    static int N, M;
    static List<List<int[]>> graph = new ArrayList<>();
    static final int MAX_NUM = 2_000 * 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, cost});
            graph.get(to).add(new int[]{from, cost});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        br.close();

        int r1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int r2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        int result = (r1 >= MAX_NUM && r2 >= MAX_NUM) ? -1 : Math.min(r1, r2);
        System.out.println(result);
    }

    private static int dijkstra(int start, int end) {

        if (start == end) return 0;

        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX_NUM);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];

            if (dist[now] < curr[1]) continue;

            for (int[] nextNode : graph.get(now)) {
                int next = nextNode[0];
                int newDist = nextNode[1] + dist[now];
                if (dist[next] > newDist) {
                    dist[next] = newDist;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        return dist[end];
    }
}
