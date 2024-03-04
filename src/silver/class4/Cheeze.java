package silver.class4;

import java.io.*;
import java.util.*;

// TODO 1. "4변 중에서 적어도 2변 이상이 실내온도의 공기와 접촉한지 한 시간만에 녹아 없어져 버린다."
// TODO 2. "단, 치즈 내부에 있는 공간은 치즈 외부 공기와 접촉하지 않는 것으로 가정한다."
// TODO 3. "모눈 종이의 맨 가장자리에는 치즈가 놓이지 않는다."
// TODO 입력으로 주어진 치즈가 모두 녹아 없어지는데 걸리는 시간 구하기

// TODO 토마토와 비슷한 문제? -> 단, "1과 인접하다고 해서 모두 익었던 토마토"와는 달리 "작은 정사각형을 기준으로 4변 중에 2변 이상이 외부에 맞닿아 있어야 녹는 치즈"
// TODO 그래프 탐색 -> BFS (Q. DFS는 왜 되지..?)
public class Cheeze {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int time = 0;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    queue.add(board[i][j]); // 'add(int[])' in 'java.util.Queue' cannot be applied to '(int)'
                    visited[i][j] = true;
                }
            }
        }

//        for (int[] ints : board) {
//            System.out.println(Arrays.toString(ints));
//        }

        calculateTime();

        System.out.println(time);
        br.close();
    }

    private static void calculateTime() {
        queue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int distance = 4;

            for (int k = 0; k < distance; k++) {
                int nx = r + dx[k];
                int ny = c + dy[k];

                // TODO 단순 탐색이 아닌,
                if ( // ..

            }
        }
    }
}
