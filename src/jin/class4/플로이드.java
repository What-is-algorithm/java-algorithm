package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 11404. 플로이드
public class 플로이드 {
    // 1. 입력 받기
    // 2. 그래프 초기화 (INF) -> 자기자신=0, 방문x=Integer.MAX_VALUE
    // 3. 이동할 때, min(이동한 곳의 비용, 시작->경유,경유->끝)
    // 시작 + 경유 + 끝 -> [i][j] = [i][k] + [k][j];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][N + 1];

        final int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    graph[i][j] = INF;
                }
            }
        }


        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from][to] = Math.min(graph[from][to], cost);
        }

//        for (int[] d : graph) {
//            System.out.println(Arrays.toString(d));
//        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <=N; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j],  graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == INF) {
                    sb.append("0").append(" ");
                    continue;
                }
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }
}
