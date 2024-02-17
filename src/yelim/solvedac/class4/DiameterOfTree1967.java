package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DiameterOfTree1967 {
    static ArrayList<Node> list[] ;
    static int n;
    static int max = 0;
    static boolean visited[];
    static int max_idx = 0;
    static class Node{
        int idx,cnt;
        Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리의 지름 : 트리에서 임의의 두 점 사이 거리 중 가장 긴 것
        // 루트 노드의 번호는 항상 1
        // 노드 수 n (1 ≤ n ≤ 10,000)
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        // 0 < 가중치 < 100
        for(int i=0; i<n-1; i++) {
            String [] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list[parent].add(new Node(child,weight));
            list[child].add(new Node(parent,weight));
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[n+1];
        visited[max_idx] = true;
        dfs(max_idx,0);

        System.out.println(max);
        br.close();
    }

    static void dfs(int idx, int cnt) {
        if (max < cnt) { // 더 길 경우 갱신
            max = cnt;
            max_idx = idx;
        }

        for (Node a : list[idx]) {
            if (!visited[a.idx]) {
                visited[a.idx] = true;
                dfs(a.idx, cnt + a.cnt); // 누적하면서 탐색
            }
        }
    }
}
