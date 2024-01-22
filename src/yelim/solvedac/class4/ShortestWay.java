package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class ShortestWay {
    static int[][] arr;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] ve = br.readLine().split(" ");
        // 정점 수
        int V = Integer.parseInt(ve[0]);
        // 간선 수
        int E = Integer.parseInt(ve[1]);

        // 출발 정점
        int K = Integer.parseInt(br.readLine());

        // 방문 처리 배열
        boolean[] check = new boolean[V+1];
        // 최단 경로 값 저장 배열
        int[] result = new int[V+1];
        // 연결 정보 저장 배열
        List<Node>[] lst = new List[V+1];

        // 연결 정보를 저장할 배열과 최단 경로 값 저장할 배열 초기화
        for(int i=1;i <= V;i++) {
            lst[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE; // 최단 경로 값을 저장하기 전 무한으로 초기화
        }

        for(int i=0;i < E;i++) {
            String[] e = br.readLine().split(" ");

            // 출발 노드
            int start = Integer.parseInt(e[0]);
            // 도착 노드
            int end = Integer.parseInt(e[1]);
            // 가중치
            int weight = Integer.parseInt(e[2]);

            // 연결 정보 저장
            lst[start].add(new Node(end, weight));
        }

        // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        // 출발노드가 자기 자신까지 가중치는 0
        result[K] = 0;
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(!check[now.end]) { // 현재 방문 노드 방문 처리
                check[now.end] = true;
            }

            // 현재 노드와 연결된 간선들에 대해
            for(int j=0;j < lst[now.end].size();j++) {
                Node next = lst[now.end].get(j); // 현재 노드에서 이어질 다음 노드

                // 다음 노드가 방문한 적이 없고 현재 노드 가중치 값 + 해당 노드로 향하는 가중치 값 < 해당 노드로의 최단 경로 값 이라면
                if(!check[next.end] && now.weight + next.weight < result[next.end]) {
                    // 해당 노드로의 최단 경로 값으로 수정
                    result[next.end] = now.weight + next.weight;
                    // 다음 방문할 예정인 노드를 우선 순위 큐에 넣기
                    pq.add(new Node(next.end, result[next.end]));
                }
            }
        }

        for(int k=1;k <= V;k++) {
            if(result[k] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }else {
                sb.append(result[k]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
