package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class WormHole {
    static BufferedReader br;
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int from;
        int to;
        int time;

        Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 도로는 양방향, 웜홀은 단방향
        // 웜홀을 통해 이동하면 시간이 감소
        // 각 지역을 연결하는 도로가 중복될 수 있다.
        // 한 지점에서 출발을 하여 다시 출발한 지점으로 돌아왔을 때,
        // 출발 하였을 때보다 시간이 되돌아가 있는 경우가 있는지 없는지
        // -> 즉, 시간이 되돌아가 있는 경우 = 음의 사이클이 있는 경우


        // 그래프의 가중치가 음수인 것을 처리할 수 있는 벨먼-포드 알고리즘
        // (데이크스트라 알고리즘은 벨먼-포드 알고리즘과 동일한 작업을 수행하고 실행속도도 더 빠르지만 음수 가중치를 처리할 수 없음)
        // 벨먼-포드 알고리즘으로 음수 사이클이 존재하는지 확인할 수 있다.
        // 음수 사이클 O -> YES, 음수 사이클 X -> NO

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] nmw = br.readLine().split(" ");
            int N = Integer.parseInt(nmw[0]);
            int M = Integer.parseInt(nmw[1]);
            int W = Integer.parseInt(nmw[2]);
            System.out.println(bellmanFord(N, M, W) ? "YES" : "NO");
        }
    }

    public static boolean bellmanFord(int M, int N, int W) throws IOException {
        ArrayList<Edge> edge = new ArrayList<>();
        for (int i = 0; i < M + W; i++) {
            String[] set = br.readLine().split(" ");
            int S = Integer.parseInt(set[0]);
            int E = Integer.parseInt(set[1]);
            int T = Integer.parseInt(set[2]);

            if (i >= M) {
                edge.add(new Edge(S, E, -T));
            } else {
                edge.add(new Edge(S, E, T));
                edge.add(new Edge(E, S, T));
            }
        }

        int[] times = new int[N + 1];
        for (int start = 1; start <= N; start++) {
            Arrays.fill(times, INF);
            times[start] = 0;
            boolean ck = false;
            for (int i = 1; i <= N; i++) {
                ck = false;
                for (int j = 0; j < edge.size(); j++) {
                    Edge cur = edge.get(j);
                    if (times[cur.from] != INF && times[cur.to] > times[cur.from] + cur.time) {
                        times[cur.to] = times[cur.from] + cur.time;
                        ck = true;
                        if (i == N) {
                            return true;
                        }
                    }
                }
                if (!ck) {
                    break;
                }
            }
        }
        return false;
    }
}
// https://tang25.tistory.com/entry/%EB%B0%B1%EC%A4%80-1865%EB%B2%88-%EC%9B%9C%ED%99%80-%EA%B7%B8%EB%9E%98%ED%94%84-%EB%B2%A8%EB%A7%8C%ED%8F%AC%EB%93%9C-%EC%9E%90%EB%B0%94