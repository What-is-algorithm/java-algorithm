package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Floyd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 플로이드-워셜 알고리즘 : 모든 노드에서 모든 노드로 가는 최소 비용 갱신, dp와 인접행렬 사용
        // A에서 B로 가는 데 필요한 비용의 최솟값
        // 2 <= n <= 100, 1 <= m <= 100000
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 인접 행렬 초기화
        int[][] cityBus = new int[n+1][n+1];
        for(int i=1;i <= n;i++) {
            Arrays.fill(cityBus[i], 100_000);
            cityBus[i][i] = 0;
        }

        for(int i=0;i < m;i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            cityBus[start][end] = Math.min(cityBus[start][end], cost);
        }

        // 1부터 n까지 i를 거쳐가는 경우
        for(int i=1;i <= n;i++) {
            // j에서 k로 가는 경우
            for(int j=1;j <= n;j++) {
                for(int k=1;k <= n;k++) {
                    // i를 거쳐가는 비용이 기존 비용보다 더 작으면 갱신
                    cityBus[j][k] = Math.min(cityBus[j][k], cityBus[j][i] + cityBus[i][k]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i <= n;i++) {
            for(int j=1;j <= n;j++) {
                sb.append(cityBus[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
