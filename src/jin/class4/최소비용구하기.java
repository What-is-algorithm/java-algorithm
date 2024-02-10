package jin.class4;

import java.io.*;
import java.util.*;

// [G5]. 1916 최소비용 구하기

public class 최소비용구하기 {
    // 1. 인접 리스트 만들기
    // 2. 거리 배열 -> new int[N+1]
    // 3. 다익스트라 -> priority queue
    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        final int INF = Integer.MAX_VALUE;

        List<List<Node>> list = new ArrayList<>();
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int result = dijkstra(from, to, list, distance, visited);
        System.out.println(result);
        br.close();
    }

    private static int dijkstra(int from, int to, List<List<Node>> list, int[] distance, boolean[] visited) {
        // 1. 출발 노드 지정
        // 2. 출발 노드를 기준으로 각 노드의 최소 비용 저장
        // 3. 방문하지 않은 노드 중 **가장 비용이 적은 노드** 선택 -> 우선순위 큐 이유 -> V^2 -> (V+E) log(V)
        // 4. 해당 노드를 거쳐 특정 노드로 가는 경우를 고려해 최소 비용 갱신
        // 5. 3~4 반복
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(from, 0));
        distance[from] = 0;

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int next = currNode.to;
            if (!visited[next]) {
                visited[next] = true;

                for (Node node : list.get(next)) {
                    // 532 ms
                    if (!visited[node.to]) {
                        distance[node.to] = Math.min(distance[node.to], distance[next] + node.weight);
                        pq.offer(new Node(node.to, distance[node.to]));
                    }
                    /* 568 ms
                    if (!visited[node.to] && distance[node.to] > distance[next] + node.weight) {
                        distance[node.to] = distance[next] + node.weight;
                        pq.offer(new Node(node.to, distance[node.to]));
                    }
                     */
                }
            }
        }

        return distance[to];
    }
}
