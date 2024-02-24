package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 17144. 미세먼지 안녕

public class 미세먼지안녕 {
    // 입력받을 때 공기청정기 위치 받기
    // 미세먼지 받는 리스트 getCanSpreadDusts(graph);
    // 미세먼지 확장 spreadFineDust(graph, dusts)
    // 공기청정기 작동 operateAirCleaner(graph, robot)
    // 남은 미세먼지 양 getTotalOfFindDust(graph)

    static class Node {
        int y, x, dust;

        public Node (int y, int x, int dust) {
            this.y = y;
            this.x = x;
            this.dust = dust;
        }
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int robot = -1;

        int[][] graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    robot = i;
                }
            }
        }

        while (T--> 0) {
            // 미세먼지 받는 리스트 getCanSpreadDusts(graph);
            List<Node> dusts = getCanSpreadDusts(graph);
            // 미세먼지 확장 spreadFineDust(graph, dusts)
            spreadFineDust(graph, dusts);
//            for (int[] g : graph) {
//                System.out.println(Arrays.toString(g));
//            }
            // 공기청정기 작동 operateAirCleaner(graph, robot)
            operateAirCleaner(graph, robot);
//            System.out.println();
//            for (int[] g : graph) {
//                System.out.println(Arrays.toString(g));
//            }
//            System.out.println("---");
        }

        // 남은 미세먼지 양 getTotalOfFindDust(graph)
        int result = getTotalOfFindDust(graph);
        System.out.println(result);
        br.close();
    }

    private static List<Node> getCanSpreadDusts(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        List<Node> dusts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                if (graph[i][j] >= 5) {
                    dusts.add(new Node(i, j, graph[i][j]));
                }
            }
        }

        return dusts;
    }

    private static void spreadFineDust(int[][] graph, List<Node> dusts) {

        Queue<Node> que = new LinkedList<>(dusts);

        while (!que.isEmpty()) {
            Node curr = que.poll();

            int amountOfFindDusts = curr.dust / 5;
            int cnt = 0;

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (!isValid(graph, ny, nx)) continue;

                graph[ny][nx] += amountOfFindDusts;
                cnt++;
            }

            graph[curr.y][curr.x] -= (amountOfFindDusts * cnt);
        }
    }

    private static void operateAirCleaner(int[][] graph, int robot) {
        int top = robot - 1;
        int down = robot;
        int r = graph.length;
        int c = graph[0].length;

        // top 반시계
        // 하
        for (int k = top - 1; k > 0; k--) {
            graph[k][0] = graph[k - 1][0];
        }
        // 좌
        for (int k = 0; k < c - 1; k++) {
            graph[0][k] = graph[0][k + 1];
        }
        // 상
        for (int k = 0; k < top; k++) {
            graph[k][c - 1] = graph[k + 1][c - 1];
        }
        // 우
        for (int k = c - 1; k >= 2; k--) {
            graph[top][k] = graph[top][k - 1];
        }
        graph[top][1] = 0;
        // down 시계
        // 상
        for (int k = down + 1; k < r - 1; k++) {
            graph[k][0] = graph[k + 1][0];
        }
        // 좌
        for (int k = 0; k < c - 1; k++) {
            graph[r - 1][k] = graph[r - 1][k + 1];
        }
        // 하
        for (int k = r - 1; k >= down + 1; k--) {
            graph[k][c - 1] = graph[k - 1][c - 1];
        }
        // 우
        for (int k = c - 1; k >= 2; k--) {
            graph[down][k] = graph[down][k - 1];
        }
        graph[down][1] = 0;
    }

    private static int getTotalOfFindDust(int[][] graph) {
        int totalRemainingFindDust = 0;
        int r = graph.length;
        int c = graph[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] > 0) {
                    totalRemainingFindDust += graph[i][j];
                }
            }
        }
        return totalRemainingFindDust;
    }

    private static boolean isValid(int[][] graph, int y, int x) {
        if (y < 0 || x < 0 || y >= graph.length || x >= graph[0].length) return false;
        if (graph[y][x] == -1) return false;

        return true;
    }

}
