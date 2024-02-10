package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// TODO n x n, 물고기 m, 아기 상어 1 (가장 처음 아기 상어 크기는 2)
// TODO 크기가 큰 물고기가 있는 칸은 지나갈 수 없음
// TODO 크기가 같은 물고기는 먹을 수 없지만, 지나갈 수 있음
// TODO 크기가 작은 물고기는 먹을 수도 있고, 지나갈 수도 있음
// TODO 먹을 수 있는 물고기가 없으면 엄마 상어에게 요청
// TODO 거리가 가까운 물고기부터 -> 거리가 가까운 물고기가 많다면 위에 있는 물고기 -> 왼쪽에 있는 물고기 -> 상좌우하 / {거리 순, y좌표, x좌표}
// TODO 이동은 1초, 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기 1++
// TODO "몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 먹을 수 있는지 count"

// TODO 틀린 풀이 (무한 반복에 빠지고 있는 것 같은데, 직접 디버깅을 해봐야 함)
public class BabyShark {
    private static int[][] board;
    private static int[] dx = {-1, 0, 0, 1}; // 상좌우하
    private static int[] dy = {0, -1, 1, 0};
    private static int move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        move = 0;
        int[] currentShark = null;

        for (int i = 0; i < n; i++) {
            String row = br.readLine().replaceAll(" ", "");
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j) - '0';
                if (board[i][j] == 9) {
                    currentShark = new int[]{i, j};
                    board[i][j] = 0;
                }
            }
        }

        bfs(n, currentShark);
        System.out.println(move);
        br.close();
    }

    // TODO while(true) : (1) ..
    private static void bfs(int n, int[] cur) {
        int sharkSize = 2;
        int eatCount = 0;
        int time = 0;

        while (true) {
            // 일요일 오후에 재풀이 예정
        }
    }
}