package jin.class4;

import java.io.*;
import java.util.*;

// [G3] 1238. 파티

public class 파티 {

    static class Node implements Comparable<Node> {
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

    // 다익스트라
    // 자신의 집에서 X집 까지 최단거리 -> 사람마다 distance 배열 초기화
    // 위의 데이터 모음 중 가장 큰 데이터 뽑기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reversedGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            reversedGraph.get(to).add(new Node(from, cost));
        }

        int result = 0;
        int[] goTimes = dijkstra(graph, new int[N + 1], new boolean[N + 1], X);
        int[] backTimes = dijkstra(reversedGraph, new int[N + 1], new boolean[N + 1], X);
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, goTimes[i] + backTimes[i]);
        }

        System.out.println(result);
        br.close();
    }

    private static int[] dijkstra(List<List<Node>> graph, int[] distance, boolean[] visited, int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int next = curr.to;
            int weight = curr.weight;

            if (!visited[next]) {
                visited[next] = true;
                for (Node node : graph.get(next)) {
                    if (!visited[node.to]) {
                        distance[node.to] = Math.min(distance[node.to], weight + node.weight);
                        pq.add(new Node(node.to, distance[node.to]));
                    }
                }
            }

        }

        return distance;
    }
}
