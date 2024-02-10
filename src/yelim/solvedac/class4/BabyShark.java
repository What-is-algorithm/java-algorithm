package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BabyShark {
    static int[][] ocean;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N X N 크기 공간에 물고기 M마리와 아기 상어 1마리
        // 한칸에 물고기 최대 1마리 존재
        // 상어와 물고기는 각각 모두 크기를 가지고 있고
        // 상어는 자기 자신보다 큰 물고기가 있는 칸은 지나갈 수 없고
        // 자신보다 크기가 작은 물고기는 먹을 수 있다.
        // 크기가 같은 물고기는 먹을 수 없지만 그 크기가 같은 물고기는 지나갈 수 있다.
        // 상어가 이동하는 시간은 1초, 먹는데 걸리는 시간은 없다.
        // 상어가 물고기를 먹으면 그 칸은 빈칸이 된다.
        // 상어는 자신의 크기와 같은 수의 물고기를 먹으면 상어 크기가 1 커진다.
        // 상어의 처음 크기는 "2"
        // 공간의 0 : 빈칸, [1,2,3,4,5,6] : 칸에 있는 물고기의 크기, 9 : 아기 상어의 위치

        int N = Integer.parseInt(br.readLine());

        ocean = new int[N][N];
        int[] shark = null; // 상어의 위치

        for(int i=0;i < N;i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0;j < N;j++) {
                ocean[i][j] = Integer.parseInt(input[j]);
                if(ocean[i][j] == 9) {
                    shark = new int[] {i, j};
                    ocean[i][j] = 0;
                }
            }
        }

        int size = 2; // 상어 크기
        int eat = 0; // 먹은 물고기 수
        int move = 0; // 움직인 총 거리

        while(true) {
            // 이동한 거리를 비교했을 때,
            // 이동 거리가 같지 않다면 적게 움직인 좌표를 우선으로
            // 이동 거리가 같은데 같은 행이 아니면 작은 인덱스의 행을 우선으로 한다.
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[N][N];

            pq.add(new int[]{shark[0], shark[1], 0}); // 행, 열, 이동한 거리
            visit[shark[0]][shark[1]] = true;

            boolean ck = false; // 상어가 먹이를 먹었는지 체크할 변수

            while (!pq.isEmpty()) {
                shark = pq.poll();

                if (ocean[shark[0]][shark[1]] != 0 && ocean[shark[0]][shark[1]] < size) { // 먹이가 있으면서 상어의 사이즈보다 작다면
                    ocean[shark[0]][shark[1]] = 0; // 물고기를 제거
                    eat++;
                    move += shark[2]; // 움직인 거리를 총 움직인 거리에 추가
                    ck = true; // 먹이 먹었다고 체크
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nr = shark[0] + dr[k];
                    int nc = shark[1] + dc[k];

                    if (nr < 0 || nc < 0 || nc >= N || nr >= N || visit[nr][nc] || ocean[nr][nc] > size)
                        continue;

                    pq.add(new int[]{nr, nc, shark[2] + 1});
                    visit[nr][nc] = true;
                }
            }

            if (!ck) // 큐가 비워질 때까지 먹이를 먹은 적이 없다면, 더 이상 먹은 물고기가 없으므로 탈출
                break;

            if (size == eat) { // 사이즈와 먹이를 먹은 수가 동일하다면 상어의 크기를 증가
                size++;
                eat = 0;
            }
        }
    }
}
// https://girawhale.tistory.com/39