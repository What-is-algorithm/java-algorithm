package jin.class4_2;

import java.io.*;
import java.util.*;

public class 파티_1238 {

    static int N, M, X;
    static final int MAX_NUM = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<int[]>> data = new ArrayList<>();
        List<List<int[]>> reversedData = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            data.add(new ArrayList<>());
            reversedData.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            data.get(from).add(new int[]{to, cost});
            reversedData.get(to).add(new int[]{from, cost});
        }
        br.close();

        int result = 0;
        int[] straight = dijkstra(data);
        int[] back = dijkstra(reversedData);
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, straight[i] + back[i]);
        }
        System.out.println(result);
    }

    private static int[] dijkstra(List<List<int[]>> data) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, MAX_NUM);
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        dist[X] = 0;
        pq.add(new int[]{X, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];

            if (!visited[now]) {
                visited[now] = true;
                for (int[] next : data.get(now)) {
                    int nextNode = next[0];
                    int newDistance = next[1] + dist[now];
                    if (!visited[nextNode] && dist[nextNode] > newDistance) {
                        dist[nextNode] = newDistance;
                        pq.add(new int[]{nextNode, dist[nextNode]});
                    }
                }
            }
        }

        return dist;
    }
}
