package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 1753. 최단 경로
public class 최단경로 {
    static class Node {
        int idx;
        int cost;

        Node (int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        int[] distance = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(K, 0));
        distance[K] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (distance[curr.idx] < curr.cost) continue;

            for (Node next : graph.get(curr.idx)) {
                int newDistance = distance[curr.idx] + next.cost;

                if (distance[next.idx] > newDistance) {
                    distance[next.idx] = newDistance;
                    pq.add(new Node(next.idx, newDistance));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(distance[i]);
            }
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }
}
