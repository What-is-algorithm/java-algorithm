package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// [S1] 2667. 단지번호붙이기
public class 단지번호붙이기 {
    static int[][] graph;
    static int cnt;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j) - 48;
            }
        }

        cnt = 0;
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    dfs(i, j, N);
                    rst.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(rst);
        System.out.println(rst.size());
        for (int num : rst) {
            System.out.println(num);
        }
    }

    private static void dfs(int y, int x, int maximum) {
        cnt++;
        graph[y][x] = -1;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (nx < 0 || ny < 0 || nx >= maximum || ny >= maximum)
                continue;
            if (graph[ny][nx] == 1) {
                graph[ny][nx] = -1;
                dfs(ny, nx, maximum);
            }
        }
    }
}
