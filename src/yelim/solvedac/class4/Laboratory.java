package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Laboratory {
    static int N;
    static int M;
    static int[][] lab;
    static int[][] viruslab;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" "); // (3 <= N, M <= 8)
        // 세로 크기
        N = Integer.parseInt(nm[0]);
        // 가로 크기
        M = Integer.parseInt(nm[1]);

        // 새로 세울 수 있는 벽은 3개
        lab = new int[N][M]; // 2 = 바이러스(2 <= 바이러스 개수 <= 10), 1 = 벽, 0 = 빈 칸(3 <= 빈 칸 개수)
        for(int i=0;i < N;i++) {
            String[] row = br.readLine().split(" ");
            for(int j=0;j < M;j++) {
                lab[i][j] = Integer.parseInt(row[j]);
            }
        }

        blockVirus(0);
        System.out.println(max);
        br.close();
    }

    static void blockVirus(int num) {
        if(num == 3) { // 새로운 벽 3개를 다 세웠다면
            virus(); // 바이러스를 퍼뜨리면서 빈칸의 수를 세면서 최대 빈칸 찾기
            return;
        }

        for(int i=0;i < N;i++) { // 모든 경우에 대해
            for(int j=0;j < M;j++) {
                if(lab[i][j] == 0) { // 벽을 세울 수 있다면
                    lab[i][j] = 1; // 벽을 세우고
                    blockVirus(num + 1); // 벽을 3개까지 세우면서 최대 빈칸 찾기 위한 재귀 함수
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void virus() { // 너비 우선 탐색으로 바이러스 퍼뜨리기
        Queue<int[]> q = new LinkedList<>();
        viruslab = new int[N][M];

        // 바이러스가 퍼뜨려질 임시 연구소
        for(int i=0;i < N;i++) {
            for(int j=0;j < M;j++) {
                viruslab[i][j] = lab[i][j];
                if(viruslab[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        // 너비 우선 탐색
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int i=0;i < 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 연구소의 범위를 벗어나지 않고 빈 칸이라면 바이러스 퍼뜨리기
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && viruslab[nx][ny] == 0) {
                    viruslab[nx][ny] = 2;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        // 바이러스가 퍼뜨려졌을 때 빈칸 수 세기
        int cnt = 0;
        for(int i=0;i < N;i++) {
            for(int j=0;j < M;j++) {
                if(viruslab[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}
