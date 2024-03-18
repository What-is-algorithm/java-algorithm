package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCost2 {
    static ArrayList<Node>[] list;
    static int n, m, start, end;
    static int[] dist;
    static int[] route; // 직전 노드 저장
    static boolean[] visited;
    public static class Node implements Comparable<Node> {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 수 (1 ≤ n ≤ 1,000)
        n = Integer.parseInt(br.readLine());
        // 버스 수 (1 ≤ m ≤ 100,000) (0 <= 버스 비용 <= 100,000)
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            list[start].add(new Node(end, cost));
        }

        start = Integer.parseInt(br.readLine());
        end = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(dist, 1000000001);
        visited = new boolean[n + 1];
        dijkstra();

        System.out.println(dist[end]);

        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());
        for(int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;

        while(!q.isEmpty()) {
            Node current = q.poll();

            if(!visited[current.e]) visited[current.e] = true;
            else continue;

            for(int i = 0; i < list[current.e].size(); i++) {
                Node next = list[current.e].get(i);
                if(dist[next.e] > dist[current.e] + next.cost) {
                    dist[next.e] = dist[current.e] + next.cost;
                    q.offer(new Node(next.e, dist[next.e]));
                    route[next.e] = current.e;
                }
            }
        }
    }
}
// https://moonsbeen.tistory.com/239