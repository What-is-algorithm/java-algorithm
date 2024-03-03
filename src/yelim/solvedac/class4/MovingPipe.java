package yelim.solvedac.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MovingPipe {
    static int N;
    static int[][] map;
    static int result;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정사각형 크기 N X N의 집에서 두 칸을 자치하는 파이프를 옮기려고 할 때,
        // 파이프는 빈칸(0)에만 있을 수 있다.(벽은 1)
        // 파이프를 움직일 수 있는 방향은 오른쪽, 오른쪽 아래 대각선, 아래쪽으로만 움직일 수 있다.
        // 파이프를 45도만 회전할 수 있다.
        // 처음 파이프는 항상 (1,1)과 (1,2)를 차지하여 가로로 놓여 있다. (배열은 1부터 시작한다.)
        // 파이프가 가로 방향일 경우, 동쪽으로 한 칸 또는 대각선으로 한 칸 이동
        // 파이프가 세로 방향일 경우, 남쪽으로 한 칸 또는 대각선으로 한 칸 이동
        // 파이프가 대각선 방향일 경우, 동쪽으로 한 칸 또는 남쪽으로 한 칸 또는 대각선으로 한 칸 이동
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i=1;i <= N;i++) {
            String[] input = br.readLine().split(" ");
            for (int j=1;j <= N;j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        result = 0;
        // 파이프의 한 쪽 끝 좌표 (1, 2)와 가로 방향 -> 초기 파이프 모양을 매개 변수로 넣기
        dfs(1, 2, 0);
    }

    static void dfs(int x, int y, int direction) {
        if (x == N && y == N) { // 파이프의 한 쪽 끝이 맨 끝으로 가면 종료
            result++;
            return;
        }

        switch (direction) {
            case 0: // 파이프가 가로 방향일 경우, 갈 수 있는 경우는 동쪽과 대각선
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    dfs(x, y + 1, 0);
                }
                break;
            case 1: // 파이프가 세로 방향일 경우, 갈 수 있는 경우는 남쪽과 대각선
                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    dfs(x + 1, y, 1);
                }
                break;
            case 2: // 파이프가 대각선일 경우, 갈 수 있는 경우는 동쪽과 남쪽, 대각선
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    dfs(x, y + 1, 0);
                }

                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    dfs(x + 1, y, 1);
                }
                break;
        }

        // 파이프가 어떤 방향이든지, 대각선은 검사해서 가장 아래로 빼기
        if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}
// https://steady-coding.tistory.com/30