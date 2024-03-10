package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class SogangGround {
    static class node implements Comparable<node>{
        int position, value;
        public node(int position, int value) {
            this.position = position;
            this.value = value;
        }
        //거리 기준 오름차순 정렬
        @Override
        public int compareTo(node o) {
            return this.value - o.value;
        }
    }
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수색 범위만큼 시작시점에서 이동할 수 있다.
        // 길은 양방향이고 1 ~ n 지역에서 시작할 때 아이템을 얻을 수 있는 최대값 출력
        String[] nmr = br.readLine().split(" ");
        // 지역 수 (1 ≤ n ≤ 100)
        int n = Integer.parseInt(nmr[0]);
        // 수색 범위 (1 ≤ m ≤ 15)
        int m = Integer.parseInt(nmr[1]);
        // 길 수 (1 ≤ r ≤ 100)
        int r = Integer.parseInt(nmr[2]);
        int[] score = new int[n+1];
        ArrayList<ArrayList<node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        String[] item = br.readLine().split(" ");
        // 각 지역 아이템 개수 배열에 저장
        for(int i = 1; i <= n; i++)
            score[i] = Integer.parseInt(item[i]);
        // 양방향 길에 대한 정보 저장
        for(int i = 0; i < r; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int l = Integer.parseInt(input[2]);

            //
            graph.get(a).add(new node(b, l));
            graph.get(b).add(new node(a, l));
        }

        // 각 지역에서 출발했을 때 최대로 먹을 수 있는 아이템 탐색
        for(int i = 1; i <= n; i++) {
            answer = Math.max(search(i, graph, score, n, m), answer);
        }
        System.out.println(answer);
        br.close();
    }

    // BFS탐색을 통해 각 지역에서 탐색범위 안에 먹을 수 있는 아이템 개수 탐색
    static int search(int start, ArrayList<ArrayList<node>> graph, int[] score, int size, int max) {
        PriorityQueue<node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[size+1];
        q.add(new node(start, 0));

        int result = 0;
        while(!q.isEmpty()) {
            node cur = q.poll();
            if(visited[cur.position] == true) continue;

            // 해당 지역 아이템 개수 증가
            result += score[cur.position];
            // 해당 지역 방문 확인
            visited[cur.position] = true;

            // 인접한 길 탐색
            for(node next : graph.get(cur.position)) {
                if(!visited[next.position] && max - (cur.value + next.value) >= 0) {
                    q.add(new node(next.position, cur.value + next.value));
                }
            }
        }
        return result;
    }
}
