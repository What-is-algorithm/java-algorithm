package jin.class4_2;

import java.util.*;
import java.io.*;

public class 미세머지안녕_17144 {

    static int R, C, T;
    static int[][] data;
    static int[] robot = new int[2]; // 공기청정기의 두 위치를 저장
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        data = new int[R][C];
        int robotIdx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == -1) {
                    robot[robotIdx++] = i; // 공기청정기 위치 저장
                }
            }
        }
        br.close();

        while (T-- > 0) {
            spread();
            cleanAir();
        }

        int result = getRemainingAmount();
        System.out.println(result);
    }

    private static int getRemainingAmount() {
        int remain = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (data[i][j] > 0) {
                    remain += data[i][j];
                }
            }
        }
        return remain;
    }

    private static void cleanAir() {
        // Top cleaner
        int top = robot[0];
        for (int i = top - 1; i > 0; i--) {
            data[i][0] = data[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            data[0][i] = data[0][i + 1];
        }
        for (int i = 0; i < top; i++) {
            data[i][C - 1] = data[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            data[top][i] = data[top][i - 1];
        }
        data[top][1] = 0;

        // Bottom cleaner
        int bottom = robot[1];
        for (int i = bottom + 1; i < R - 1; i++) {
            data[i][0] = data[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            data[R - 1][i] = data[R - 1][i + 1];
        }
        for (int i = R - 1; i > bottom; i--) {
            data[i][C - 1] = data[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            data[bottom][i] = data[bottom][i - 1];
        }
        data[bottom][1] = 0;
    }

    private static void spread() {
        int[][] temp = new int[R][C];
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (data[y][x] > 0) {
                    int amount = data[y][x] / 5;
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (ny >= 0 && ny < R && nx >= 0 && nx < C && data[ny][nx] != -1) {
                            temp[ny][nx] += amount;
                            count++;
                        }
                    }
                    data[y][x] -= amount * count;
                }
            }
        }
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                data[y][x] += temp[y][x];
            }
        }
    }
}
