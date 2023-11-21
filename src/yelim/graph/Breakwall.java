package yelim.graph;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Breakwall {
    static class Loc{
        int i;
        int j;
        int cnt;
        boolean destroyed;

        public Loc(int i, int j, int cnt, boolean d) {
            this.i = i;
            this.j = j;
            // 이동한 칸 수
            this.cnt = cnt;
            // 벽을 부순 여부
            this.destroyed = d;
        }
    }

    // 벽을 최대 한번까지 부술 수 있다.
    // 한번도 벽을 부순적이 없다면 -> 벽을 부수고 이동한다.
    // 한번이라도 벽을 부순적이 있으면 -> 갈 수 없다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        // 가로(행)
        int n = Integer.parseInt(inputs[0]);
        // 세로(열)
        int m = Integer.parseInt(inputs[1]);

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, false));

        int[] mi = {0, 0, -1, 1};
        int[] mj = {-1, 1, 0, 0};

        // visited[n][m][0]은 벽을 한번도 안 부수고 탐색한 경우,
        // visited[n][m][1]은 벽을 한번 부수고 탐색한 경우
        boolean[][][] visited = new boolean[n][m][2];

        while (!q.isEmpty()) {
            Loc now = q.poll();

            // (N, M)의 위치까지 이동하였을 때,
            if (now.i == n - 1 && now.j == m - 1) {
                // 이동한 칸 수 출력
                System.out.println(now.cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                // 범위를 벗어난다면,
                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;


                // 범위를 벗어나지 않고
                int next_cnt = now.cnt + 1;

                // 벽이 아니면
                if(map[ni][nj]=='0'){
                    // 벽을 부신 적이 없다면
                    if(!now.destroyed && !visited[ni][nj][0]) {
                        q.add(new Loc(ni, nj, next_cnt, false));
                        visited[ni][nj][0] = true;
                    }
                    // 벽을 부신 적이 있으면
                    else if(now.destroyed && !visited[ni][nj][1]){
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }

                }else if(map[ni][nj]=='1'){ // 벽이면
                    // 한번도 벽을 부순 적이 없다면 부순다
                    if(!now.destroyed) {
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }
                }
            }

        }

        System.out.println(-1);
    }
}
