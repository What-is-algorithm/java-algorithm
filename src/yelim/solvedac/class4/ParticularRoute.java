package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class NodeEdge implements Comparable<NodeEdge> {
    int end;
    int cost;

    NodeEdge(int end, int weight) {
        this.end = end;
        this.cost = weight;
    }

    @Override
    public int compareTo(NodeEdge o) {
        return cost - o.cost;
    }
}

public class ParticularRoute {
    static int N;
    static int E;
    static ArrayList<ArrayList<NodeEdge>> lst;
    static int[] dist;
    static boolean[] check;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1번 정점에서 임의로 주어진 두 정점을 반드시 통과하면서 N번 정점까지의 최단 경로 구하기
        // 한번 이동했던 정점이나 간선도 다시 이동 가능
        String[] ne = br.readLine().split(" ");
        // 정점의 수 (2 ≤ N ≤ 800)
        N = Integer.parseInt(ne[0]);
        // 간선의 수 (0 ≤ E ≤ 200,000)
        E = Integer.parseInt(ne[1]);

        lst = new ArrayList<>();
        for(int i=0;i <= N;i++) {
            lst.add(new ArrayList<>());
        }

        for(int i=0;i < E;i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            lst.get(start).add(new NodeEdge(end, cost));
            lst.get(end).add(new NodeEdge(start, cost));
        }

        // 두 정점을 거친다는 것은 두 정점을 방문하는 순서는 상관없다는 것?
        String[] passNode = br.readLine().split(" ");
        int passNode1 = Integer.parseInt(passNode[0]);
        int passNode2 = Integer.parseInt(passNode[1]);

        // 1 -> passNode1 -> passNode2 -> N
        int result1 = 0;
        result1 += dijkstra(1, passNode1);
        result1 += dijkstra(passNode1, passNode2);
        result1 += dijkstra(passNode2, N);

        // 1 -> passNode2 -> passNode1 -> N
        int result2 = 0;
        result2 += dijkstra(1, passNode1);
        result2 += dijkstra(passNode1, passNode2);
        result2 += dijkstra(passNode2, N);

        System.out.println((result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2));
        br.close();
    }

    static int dijkstra(int start, int end) {
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<NodeEdge> pq = new PriorityQueue<>();
        check = new boolean[N+1];
        pq.offer(new NodeEdge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            NodeEdge curRoad = pq.poll();
            int cur = curRoad.end;

            if(!check[cur]) {
                check[cur] = true;

                for(NodeEdge r : lst.get(cur)) { // 도착한 현재 지점과 연결된 모든 루트 중
                    if(!check[r.end] && dist[r.end] > (dist[cur] + r.cost)) { // 방문한 적 없고, 도착한 지점까지의 비용과 연결된 지점의 합이 더 작다면
                        dist[r.end] = dist[cur] + r.cost; // 더 작은 합으로 갱신하고
                        pq.add(new NodeEdge(r.end, dist[r.end]));
                    }
                }
            }
        }

        return dist[end];
    }
}
