package yelim.solvedac.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Route implements Comparable<Route> {
    int end;
    int cost;

    Route(int end, int weight) {
        this.end = end;
        this.cost = weight;
    }

    @Override
    public int compareTo(Route o) {
        return cost - o.cost;
    }
}

public class MinimumCost {
    static int N;
    static int M;
    static ArrayList<ArrayList<Route>> lst;
    static int[] dist;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 수 N (1 <= N <= 1000)
        // 버스 수 M (1 <= M <= 100000)
        // 0 <= 버스 비용 <= 100000
        // 구하고자 하는 구간 ->  출발점의 도시 번호에서 도착점의 도시 번호까지 최소 비용 구하기
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        lst = new ArrayList<>();
        // 시작점에서 각 정점으로 가는 최단 거리
        dist = new int[N+1];
        check = new boolean[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0;i <= N;i++) {
            lst.add(new ArrayList<>());
        }

        for(int i=0;i < M;i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            lst.get(start).add(new Route(end, cost));
        }

        String[] result = br.readLine().split(" ");
        int fromCity = Integer.parseInt(result[0]);
        int toCity = Integer.parseInt(result[1]);

        System.out.println(dijkstra(fromCity, toCity));
        br.close();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        pq.offer(new Route(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Route curRoute = pq.poll();
            int cur = curRoute.end; // 도착한 현재 지점

            if(!check[cur]) {
                check[cur] = true;

                for(Route r : lst.get(cur)) { // 도착한 현재 지점과 연결된 모든 루트 중
                    if(!check[r.end] && dist[r.end] > (dist[cur] + r.cost)) { // 방문한 적 없고, 도착한 지점까지의 비용과 연결된 지점의 합이 더 작다면
                        dist[r.end] = dist[cur] + r.cost; // 더 작은 합으로 갱신하고
                        pq.add(new Route(r.end, dist[r.end])); // 그 루트로 계속 탐색
                    }
                }
            }
        }

        return dist[end];
    }
}
// https://steady-coding.tistory.com/84