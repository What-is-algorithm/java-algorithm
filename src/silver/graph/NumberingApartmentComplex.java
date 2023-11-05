package silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class NumberingApartmentComplex {
    // 상 우 하 좌 (행렬 기준, 시계 방향)
    private static final int[] di = {-1, 0, 1, 0};
    private static final int[] dj = {0, 1, 0, -1};
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int range;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 지도의 크기
        ArrayList<Integer> numList = new ArrayList<>(); // num을 담을 배열

        // 1. 지도 초기화
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        // 2. 방문 유무 초기화
        visited = new boolean[n][n];

        // 3. dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    range++;
                    num = 0;

                    dfs(i, j);
                    numList.add(num);
                }
            }
        }

        // 4. 정렬
        Collections.sort(numList);

        // 5. 출력
        System.out.println(range);
        for (int element : numList) {
            System.out.println(element);
        }

        br.close();
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        map[i][j] = range;
        num++;

        for (int k = 0; k < 4; k++) {
            int ci = i + di[k];
            int cj = j + dj[k];

            if (ci >= 0 && ci < n && cj >= 0 && cj < n) {
                if (!visited[ci][cj] && map[ci][cj] == 1) {
                    dfs(ci, cj);
                }
            }
        }
    }
}
