package jin.class4_2;

import java.io.*;
import java.util.*;

public class 연구소_14502 {

    static int N, M;
    static int[][] data;
    static List<Node> blankList = new ArrayList<>();
    static List<Node> virusList = new ArrayList<>();
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        int result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 0) {
                    blankList.add(new Node(i, j));
                } else if (data[i][j] == 2) {
                    virusList.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < blankList.size() - 2; i++) {
            for (int j = i + 1; j < blankList.size() - 1; j++) {
                for (int k = j + 1; k < blankList.size(); k++) {
                    Node fir = blankList.get(i);
                    Node sec = blankList.get(j);
                    Node thr = blankList.get(k);

                    data[fir.y][fir.x] = 1;
                    data[sec.y][sec.x] = 1;
                    data[thr.y][thr.x] = 1;
                    int[][] temp = spreadVirus();
                    result = Math.max(result, countSafeZone(temp));
                    data[thr.y][thr.x] = 0;
                    data[sec.y][sec.x] = 0;
                    data[fir.y][fir.x] = 0;
                }
            }
        }

        System.out.println(result);
    }

    private static int[][] spreadVirus() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(data[i], 0, temp[i], 0, M);
        }

        Queue<Node> que = new LinkedList<>(virusList);
        while (!que.isEmpty()) {
            Node curr = que.poll();

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];
                if (isValid(ny, nx)) {
                    if (temp[ny][nx] == 0) {
                        temp[ny][nx] = 2;
                        que.add(new Node(ny, nx));
                    }
                }
            }
        }

        return temp;
    }

    private static int countSafeZone(int[][] temp) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    static class Node {
        int y, x;

        public Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
