package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 14938. 서강그라운드

public class 서강그라운드 {

    static int n, m, r;
    static int[][] data;
    static int[] items;
    static final int INF = (int) 1e9;

    // 다익스트라 - 각 노드에서 다른 모든 노드의 최단거리 -> 한 지점을 출발할 때 최단거리임 -> 모든 노드를 돌아야 한다면? -> for(n): 다익스트라 -> bad
    // 플로이드 워셜 - 모든 노드 간의 최단 경로를 한 번에 계산. 이것도 그래프 크기가 크면 안좋겠네.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        data = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(data[i], INF);
            data[i][i] = 0;
        }

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            data[a][b] = data[b][a] = l;
        }

        floydWarshall();
        int maxTime = getMaxTime();

        System.out.println(maxTime);
        br.close();
    }

    static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    data[i][j] = Math.min(data[i][j], data[i][k] + data[k][j]);
                }
            }
        }
    }

    static int getMaxTime() {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int itemCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (data[i][j] <= m) {
                    itemCnt += items[j];
                }
            }
            result = Math.max(result, itemCnt);
        }
        return result;
    }
}
