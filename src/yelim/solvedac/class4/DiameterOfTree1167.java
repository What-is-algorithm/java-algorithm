package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DiameterOfTree1167 {
    static ArrayList<Node>[] list;
    static boolean[] check;
    static int max = 0;
    static int node;
    static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리의 지름 : 트리에서 임의의 두 점 사이 거리 중 가장 긴 것
        // 무방향?
        // 자바 1초에 1억변 계산
        // 트리의 정점 개수 V (2 <= V <= 100000)
        int V = Integer.parseInt(br.readLine());
        // 최대 간선 수 = V(V-1) / 2

        list = new ArrayList[V+1];
        for(int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < V; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            for(int j=2;j < input.length;j = j + 2) {
                int e = Integer.parseInt(input[j-1]);
                if(e == -1) break;
                int cost = Integer.parseInt(input[j]);
                list[s].add(new Node(e, cost));
            }
        }

        //임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        check = new boolean[V+1];
        dfs(1, 0);

        //node에서 부터 가장 먼 노트까지의 거리를 구한다.
        check = new boolean[V+1];
        dfs(node, 0);

        System.out.println(max);
    }

    static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        check[x] = true;

        for(int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if(!check[n.e]) {
                dfs(n.e, n.cost + len);
                check[n.e] = true;
            }
        }
    }
}
// https://moonsbeen.tistory.com/101