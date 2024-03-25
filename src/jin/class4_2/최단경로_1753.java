package jin.class4_2;

import java.io.*;
import java.util.*;

public class 최단경로_1753 {

    static int V, E;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }

        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] < INF ? distance[i] : "INF").append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.to, weight = curr.weight;

            if (distance[now] < weight) continue;

            for (Node next : graph.get(now)) {
                int newDistance = distance[now] + next.weight;
                if (distance[next.to] > newDistance) {
                    distance[next.to] = newDistance;
                    pq.add(new Node(next.to, newDistance));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int to, weight;

        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
