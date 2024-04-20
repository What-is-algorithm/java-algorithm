package jin.class4_2;

import java.io.*;
import java.util.*;

public class 플로이드_11404 {

    static int N, M;
    static int[][] data;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        data = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    data[i][j] = INF;
                }
            }
        }
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
            data[from][to] = Math.min(data[from][to], cost);
        }
        br.close();

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (data[i][k] != INF && data[k][j] != INF) {
                        data[i][j] = Math.min(data[i][j], data[i][k] + data[k][j]);
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result.append(data[i][j] == INF ? 0 : data[i][j]).append(" ");
            }
            result.deleteCharAt(result.length() - 1);
            result.append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }
}
