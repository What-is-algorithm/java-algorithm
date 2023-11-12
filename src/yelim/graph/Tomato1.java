package yelim.graph;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Tomato1 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] check;
    static Queue<int[]> q;
    // 위, 오른쪽, 아래, 왼쪽
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int ci, cj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        // 가로
        M = Integer.parseInt(str[0]);
        // 세로
        N = Integer.parseInt(str[1]);

        // 토마토 (익은 토마토 : 1, 익지 않은 토마토 : 0, 토마토 없음 : -1)
        arr = new int[N][M];
        // 토마토 구성을 배열에 저장할 때 익은 토마토가 어디 있는지 미리 큐에 저장한다.
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] tmt = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tmt[j]);
                // 익은 토마토가 있는 위치부터 탐색하기
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        // 방문 여부
        check = new boolean[N][M];

        System.out.println(bfs());
    }

    static int bfs() {
        int max = 0; // max = 3
        while (!q.isEmpty()) {
            int[] tmp = q.poll(); // 큐에 익은 토마토의 위치들이 들어가 있다.
            int x = tmp[0];
            int y = tmp[1];

            // 기준 좌표의 4가지 방향으로 탐색하기
            for (int k = 0; k < 4; k++) {
                ci = di[k] + x;
                cj = dj[k] + y;

                // 범위를 벗어나지 않는지
                if (ci >= 0 && cj >= 0 && ci < N && cj < M) {
                    // 방문하지 않고 안 익은 토마토인지
                    if (!check[ci][cj] && arr[ci][cj] == 0) {
                        // 기준 좌표의 익는 데 걸린 일에 +1
                        arr[ci][cj] = arr[x][y] + 1;
                        // 토마토가 익는 일 수 저장
                        max = arr[ci][cj];
                        // 익은 토마토 방문 처리
                        check[ci][cj] = true;
                        q.add(new int[]{ci, cj});
                    }
                }
            }
        }

        // 하나라도 익지 못한 토마토가 있다면
        if(checkZero()) {
            return -1;
        }else { // 익은 토마토로 표헌한 1에서 시작했으므로 -1
            return max - 1;
        }

    }

    // 하나라도 익지 못한 토마토가 있는지 확인하는 함수
    static boolean checkZero() {
        for(int i=0;i < N;i++) {
            for(int j=0;j < M;j++) {
                if(arr[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
