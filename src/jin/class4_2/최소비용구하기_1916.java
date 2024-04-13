package jin.class4_2;

import java.io.*;
import java.util.*;

public class 최소비용구하기_1916 {

    static int N, M;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, weight});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(distance[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        pq.add(new int[]{start, 0});
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];

            if (distance[now] < curr[1]) continue;

            for (int[] next : graph.get(now)) {
                int nextNode = next[0], newDistance = distance[now] + next[1];
                if (distance[nextNode] > newDistance) {
                    distance[nextNode] = newDistance;
                    pq.add(new int[]{nextNode, newDistance});
                }
            }
        }

    }
}
