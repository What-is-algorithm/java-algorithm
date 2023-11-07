package yelim.graph;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 인접 리스트 : 그래프의 연결 관계를 연결 리스트로 표현
// 연결된 정보만 저장하여 효율적인 메모리 사용이 가능하다. (하지만 노드가 연결 정보 확인의 시간 복잡도는 O(n)이다.)
// 이 문제의 경우 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000) 둘다 범위가 넓어
// 많은 정보를 저장하기 위해서는 효율적인 메모리 사용이 가능한 인접 리스트를 활용한다.

// DFS 깊이 우선 탐색
// 스택을 이용 -> 재귀 함수 활용
// 탐색 수행 시, O(n)의 시간 복잡도
public class Dfs1 {
    static int N;
    static int M;
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

        // 인접 리스트
        lst = new ArrayList[N+1];

        // 각 정점에 연결된 정점들을 저장할 ArrayList 초기화
        for(int l=1;l < N+1;l++) {
            lst[l] = new ArrayList<>();
        }

        // 각 정점 연결 정보 인접 리스트에 저장
        for(int i=0;i < M;i++) {
            String[] link = br.readLine().split(" ");

            int a = Integer.parseInt(link[0]);
            int b = Integer.parseInt(link[1]);

            // 무방향 그래프이므로 서로 저장
            lst[a].add(b);
            lst[b].add(a);
        }

        // 오름 차순으로 방문하기 위한 정렬
        for(ArrayList node : lst) {
            if(node != null) {
                Collections.sort(node);
            }
        }

        // 각 정점 방문 여부 초기화
        boolean[] visited = new boolean[N+1];
        // 각 정점을 몇번째로 방문했는지 저장할 배열
        int[] answer = new int[N+1];

        // 순서 변수
        seq = 1;

        dfs(R, visited, answer);

        StringBuilder sb = new StringBuilder();
        for(int k=1;k < answer.length;k++) {
            sb.append(answer[k]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, boolean[] visited, int[] answer) {
        visited[start] = true;
        // 이 정점을 방문한 순서 저장
        answer[start] = seq++;

        for(int j=0;j < lst[start].size();j++) {
            // 이 정점을 방문하지 않았다면
            if(!visited[lst[start].get(j)]) {
                dfs(lst[start].get(j), visited, answer);
            }
        }
    }
}
