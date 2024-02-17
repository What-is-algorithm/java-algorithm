package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 1504. 특정한 최단 경로

public class 특정한최단경로 {

    static class Node implements Comparable<Node>{
        int idx, weight;

        public Node (int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }

    }
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 시작 노드에서 각 노드에 대한 최단거리 -> 다익스트라
        // 1번째 노드에 대한 최단거리, 2번째 노드에 대한 최단거리 -> 최단거리 갱신
        // 시작 -> 1 -> 2 -> 도착
        // 시작 -> 2 -> 1 -> 도착

        int result1 = dijkstra(graph, 1, v1) + dijkstra(graph, v1, v2) + dijkstra(graph, v2, N);
        int result2 = dijkstra(graph, 1, v2) + dijkstra(graph, v2, v1) + dijkstra(graph, v1, N);
        int result = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);
        System.out.println(result);
        br.close();
    }

    private static int dijkstra(List<List<Node>> graph, int start, int end) {
        if (start == end) return 0;

        Queue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, INF);
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.weight > distance[curr.idx]) continue;

            for (Node next : graph.get(curr.idx)) {
                int newDist = distance[curr.idx] + next.weight;

                if (distance[next.idx] > newDist) {
                    distance[next.idx] = newDist;
                    pq.offer(new Node(next.idx, newDist));
                }
            }
        }

//        System.out.printf("s=%d, e=%d, distance=%s\n", start, end, Arrays.toString(distance));
        return distance[end];
    }
}
