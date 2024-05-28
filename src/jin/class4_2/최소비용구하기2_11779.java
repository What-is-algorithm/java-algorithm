package jin.class4_2;

import java.io.*;
import java.util.*;

public class 최소비용구하기2_11779 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, cost});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[n + 1];
        int[] previous = new int[n + 1];
        Arrays.fill(distance, INF);
        Arrays.fill(previous, -1);
        dijkstra(start, graph, distance, previous);

        StringBuilder result = new StringBuilder();
        result.append(distance[end]).append("\n");
        List<Integer> cities = getPath(previous, end);
        result.append(cities.size()).append("\n");
        for (Integer city : cities) {
            result.append(city).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

    private static void dijkstra(int start, List<List<int[]>> graph, int[] distance, int[] previous) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];
            int currWeight = curr[1];

            if (distance[now] < currWeight) continue;

            for (int[] node : graph.get(now)) {
                int next = node[0];
                int nextDistance = node[1] + currWeight;
                if (distance[next] > nextDistance) {
                    distance[next] = nextDistance;
                    previous[next] = now;
                    pq.add(new int[]{next, nextDistance});
                }
            }
        }
    }

    private static List<Integer> getPath(int[] previous, int end) {
        List<Integer> path = new ArrayList<>();

        while (end != -1) {
            path.add(end);
            end = previous[end];
        }

        Collections.reverse(path);
        return path;
    }
}
