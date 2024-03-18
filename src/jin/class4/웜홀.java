package jin.class4;

import java.io.*;
import java.util.*;

// [G3] 1865. 웜홀

public class 웜홀 {

    static Node[] graph;
    static int[] distance;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        while (TC--> 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph = new Node[2 * M + W];
            distance = new int[N + 1];
            Arrays.fill(distance, INF);
            distance[1] = 0;

            int idx = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[idx++] = new Node(S, E, T);
                graph[idx++] = new Node(E, S, T);
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[idx++] = new Node(S, E, -T);
            }

            if (bellmanFord(N)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }

    static boolean bellmanFord(final int N) {
        for (int i = 1; i < N; i++) {
            for (Node curr : graph) {
                if (distance[curr.to] > distance[curr.from] + curr.cost) {
                    distance[curr.to] = distance[curr.from] + curr.cost;
                }
            }
        }

        for (Node curr : graph) {
            if (distance[curr.to] > distance[curr.from] + curr.cost) {
                return true;
            }
        }

        return false;
    }

    static class Node {
        int from, to, cost;

        Node (int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
