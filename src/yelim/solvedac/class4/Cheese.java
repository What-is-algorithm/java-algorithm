package yelim.solvedac.class4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Cheese {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static List<Integer> list = new ArrayList<>(); // 치즈 개수가 들어갈 list
    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 치즈의 모서리(입력 배열에서 0과 맞닿아 있는 부분 중에서 바깥부분)이 시간마다 녹는다고 했을 때,
        // 치즈가 다 녹는 시간과 다 녹기 직전 시간의 치즈의 개수를 구하기
        // 모눈종이의 맨 가장자리에는 치즈가 놓이지 않는 것으로 가정
        String[] nm = br.readLine().split(" ");
        // 세로, 행
        N = Integer.parseInt(nm[0]);
        // 가로, 열
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i < N;i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0;j < M;j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean flag = true; // 모든 치즈가 녹아 없어지면 flag는 false
        int time = 0; // 시간
        int firstCount = getCount(); // 초기상태 치즈의 개수

        while(flag) {
            time++;
            bfs(new Location(0, 0));
            for(int i=0;i < N;i++) {
                Arrays.fill(visited[i], false); // 다음 시간에 치즈를 녹이기 위해 visited 배열 전부 false를 넣어줌
            }

            int count = getCount();

            if(count == 0) {
                flag = false;
            }else {
                list.add(count);
            }
        }

        System.out.println(time);

        if(list.size() > 0) { // 치즈가 전부 녹는데 2시간 이상인 경우
            System.out.println(list.size() - 1);
        }else { // 1시간만에 치즈가 다 녹는 경우 혹은 치즈가 하나도 없을 때
            System.out.println(firstCount);
        }
    }

    static void bfs(Location location) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(location);
        visited[location.x][location.y] = true;

        while(!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i=0;i < 4;i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) { // 치즈의 모서리를 일단 2로 변경한다.
                            map[nx][ny] = 2;
                            visited[nx][ny] = true;
                        }
                        if (map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            queue.add(new Location(nx, ny));
                        }
                    }
                }
            }
        }

        removeCheese(); // 배열의 값이 2면 치즈의 모서리이므로 0으로 바꾸어 녹여버림
    }

    static void removeCheese() {
        for (int i=0;i < N;i++) {
            for (int j=0;j < M;j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
    }

    static int getCount() {
        int count = 0;

        for (int i=0;i < N;i++) {
            for (int j=0;j < M;j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
// https://easybrother0103.tistory.com/89