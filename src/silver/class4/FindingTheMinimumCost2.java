package silver.class4;

import java.io.*;
import java.util.*;

// TODO 최소 비용 구하기 : 다익스트라, 플로이드, BFS (벨만포드는 잘 안쓰이니 제외)
// TODO A -> B로 가는데 드는 최소 비용과 최소 경로 구하기
// TODO (1) (1번 정점이 입력값으로 안들어오는 경우는 고려를 안했지만) 1번 노드 -> n번 노드까지의 최소 비용(또는 경로) 구하기 => 다익스트라

// TODO Q. 다익스트라와 플로이드워셜, BFS의 기본 구조가 흐릿하게 기억난다는 점
public class FindingTheMinimumCost2 {
    static class City implements Comparable<City> {
        int to;
        int weight;

        public City(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(City o) { // 비용 오름차순 정렬 -> 최소 비용순으로 정렬
            return this.weight - o.weight;
        }
    }

    // 다익스트라는 인접한 노드들을 기준으로 한 노드에서 n개의 노드까지 이동하는 알고리즘
    // 즉, 각 정점까지의 최단 경로를 모두 찾음
    // (1) 인접 리스트 구현
    static int n, m;
    // TODO "최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력"을 위해 경로 역추적을 구현.
    static int[] minCost;
    static int[] preCity;
    static int start, end; // 왜 필요할까?
    static List<List<City>> graph; // 객체를 왜 썼을까?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // (2) 그래프 초기화
        minCost = new int[n + 1];
        preCity = new int[n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        // (3) 그래프에 간선 및 노드값 세팅
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<City>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new City(to, weight));
        }

//        for (List<City> cities : graph) {
//            System.out.println(cities);
//        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // (4) 다익스트라 탐색 + 최소 비용 출력
        dijkstra(start);
        System.out.println(minCost[end]);

        // (5) 최소 경로에 포함된 도시의 수 + 최소 경로 출력
        int cityNum = 0;

        Stack<Integer> stack = new Stack<>(); // TODO 역추적 로직 복기 요망.
        stack.push(end);
        while (preCity[end] != 0) {
            cityNum += 1;
            stack.push(preCity[end]);
            end = preCity[end];
        }
        System.out.println(cityNum + 1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " "); // TODO. (오류) "1 3 5"이 아닌 "1 4 5" 출력.
        }

        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<City>();
        pq.add(new City(start, 0));
        minCost[start] = 0;

        while (!pq.isEmpty()) {
            City currentCity = pq.poll();
            int current = currentCity.to;
            if (minCost[current] < currentCity.weight) {
                continue;
            }

            for (City next : graph.get(current)) {
                if (minCost[next.to] > minCost[current] + next.weight) {
                    minCost[next.to] = minCost[current] + next.weight;

                    preCity[next.to] = current;
                    pq.offer(new City(next.to, minCost[next.to]));
                }
            }
        }
    }
}
