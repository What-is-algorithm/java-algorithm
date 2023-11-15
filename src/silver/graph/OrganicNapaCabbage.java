package silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OrganicNapaCabbage {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static boolean[][] visited;
    private static int m;
    private static int n;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken()); // 가로 = 열
            n = Integer.parseInt(st.nextToken()); // 세로 = 행
            int k = Integer.parseInt(st.nextToken()); // 심어진 배추의 개수

            // 1. 초기화
            map = new int[n][m];
            visited = new boolean[n][m];

            // 2. 정보 추가
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                map[h][w] = 1;
            }

            // 3. 탐색
            ArrayList<Integer> sumList = new ArrayList<>();
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (!visited[x][y] && map[x][y] == 1) {
                        num = 0;
                        dfs(x, y);
                        sumList.add(num);
                    }
                }
            }

            System.out.println(sumList.size());
        }

        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        num++;

        int direction = 4;
        for (int d = 0; d < direction; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
