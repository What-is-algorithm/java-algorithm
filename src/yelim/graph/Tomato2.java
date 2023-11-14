package yelim.graph;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class PointXYZ {
    int row;
    int col;
    int height;

    public PointXYZ(int height, int row, int col) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}

public class Tomato2 {
    // 3차원이므로 6방향을 탐색
    static int rowArr[] = {-1, 0, 1, 0, 0, 0};
    static int colArr[] = {0, 1, 0, -1, 0, 0};
    static int heightArr[] = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static int tomato[][][];
    static int result;
    static Queue<PointXYZ> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로
        M = Integer.parseInt(st.nextToken());
        // 세로
        N = Integer.parseInt(st.nextToken());
        // 높이
        H = Integer.parseInt(st.nextToken());

        // 토마토가 담길 공간 초기화
        tomato = new int[H + 1][N + 1][M + 1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    // 익은 토마토 위치부터 탐색하기 위해 큐에 넣기
                    if (tomato[i][j][k] == 1) queue.add(new PointXYZ(i, j, k));
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            PointXYZ point = queue.poll();

            int row = point.row;
            int col = point.col;
            int height = point.height;

            // 6방향으로 탐색
            for (int i = 0; i < 6; i++) {
                int newHeight = height + heightArr[i];
                int newRow = row + rowArr[i];
                int newCol = col + colArr[i];

                // 범위를 벗어나지 않고 익은 토마토인지
                if (checkPoint(newHeight, newRow, newCol)) {
                    // 익은 토마토를 큐에 추가
                    queue.add(new PointXYZ(newHeight, newRow, newCol));
                    // 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
                    tomato[newHeight][newRow][newCol] = tomato[height][row][col] + 1;
                }
            }
        }

        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    // 하나라도 익지 않은 토마토가 있는지
                    if (tomato[i][j][k] == 0) {
                        return -1;
                    }
                    // 토마토가 익는데 걸리는 시간을 구함
                    result = Math.max(result, tomato[i][j][k]);
                }
            }
        }
        if (result == 1) { // 이미 모든 토마토가 익어 있다면
            return 0;
        } else { // 익은 토마토인 1에서 시작했으므로 -1
            return result - 1;
        }

    }

    // 범위를 벗어나지 않고 익은 토마토인지 확인하는 함수
    public static boolean checkPoint(int height, int row, int col) {
        // 주어진 범위 밖인지
        if (height < 1 || height > H || row < 1 || row > N || col < 1 || col > M) {
            return false;
        }
        // 아직 익지 않은 토마토인지
        if (tomato[height][row][col] == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
