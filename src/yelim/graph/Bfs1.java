package yelim.graph;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

// BFS 너비 우선 탐색
// 큐를 이용하여 가까운 노드부터 탐색할 수 있다.
// 탐색 수행 시 O(n)의 시간 복잡도를 가지며 일반적으로 DFS보다 조금 더 빠르게 동작한다.
public class Bfs1 {
    static int N;
    static int M;
    static Queue<Integer> q;
    static ArrayList<Integer>[] lst;
    static int seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmr = br.readLine().split(" ");
        // 정점의 수
        N = Integer.parseInt(nmr[0]);
        // 간선의 수
        M = Integer.parseInt(nmr[1]);
        // 시작 정점
        int R = Integer.parseInt(nmr[2]);

        // 너비 우선 탐색을 위한 큐
        q = new LinkedList<>();
        // 간선 정보를 담는 인접 리스트
        lst = new ArrayList[N+1];

        // 각 정점에 연결된 정점들을 저장할 ArrayList 초기화
        for(int i=1;i < N+1;i++) {
            lst[i] = new ArrayList<>();
        }

        // 각 정점 연결 정보 인접 리스트에 저장
        for(int j=0;j < M;j++) {
            String[] link = br.readLine().split(" ");

            int a = Integer.parseInt(link[0]);
            int b = Integer.parseInt(link[1]);

            // 무방향 그래프이므로 서로 저장
            lst[a].add(b);
            lst[b].add(a);
        }

        // 오름 차순으로 방문하기 위한 정렬
        for(ArrayList node : lst) {
            if(node != null && node.size() > 1) {
                Collections.sort(node);
            }
        }

        // 각 정점 방문 여부 초기화
        boolean[] visited = new boolean[N+1];
        // 각 정점을 몇번째로 방문했는지 저장할 배열
        int[] answer = new int[N+1];

        // 순서 변수
        seq = 1;
        
        bfs(R, visited, answer);

        StringBuilder sb = new StringBuilder();
        for(int l=1;l < answer.length;l++) {
            sb.append(answer[l]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int start, boolean[] visited, int[] answer) {
        // 처음 시작 노드 방문 처리
        visited[start] = true;
        // 시작 노드 탐색을 위해 큐에 넣기
        q.add(start);

        // 인접 리스트에 탐색할 노드가 없을 때까지
        while(!q.isEmpty()) {
            // 큐에서 탐색 노드 가져오기
            int n = q.poll();
            // 탐색한 노드의 탐색 순서 저장
            answer[n] = seq++;

            for(int k=0;k < lst[n].size();k++) {
                // 이 정점을 방문하지 않았다면
                if(!visited[lst[n].get(k)]) {
                    // 이 정점을 방문 처리하고 
                    visited[lst[n].get(k)] = true;
                    // 이 노드에서 탐색 계속하도록 큐에 넣기
                    q.add(lst[n].get(k));
                }
            }
        }
    }
}