package jin.class4;

import java.io.*;
import java.util.*;

// [G3] 17236. 아기 상어

public class 아기상어 {
    static class Shark implements Comparable<Shark> {
        int y, x, move;

        public Shark (int y, int x, int move) {
            this.y = y;
            this.x = x;
            this.move = move;
        }

        @Override
        public int compareTo(Shark other) {
            return this.move != other.move ? Integer.compare(this.move, other.move)
                    : this.y != other.y ? Integer.compare(this.y, other. y)
                    : Integer.compare(this.x, other.x);
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        // 1. 입력받기 -> 첫 크기 : 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        StringTokenizer st;
        Shark start = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    start = new Shark(i, j, 0);
                    graph[i][j] = 0;
                }
            }
        }

        int result = bfs(graph, start);
        System.out.println(result);
        br.close();
    }

    private static int bfs(int[][] graph, Shark start) {
        int N = graph.length;
        int result = 0;
        Queue<Shark> pq = new PriorityQueue<>();
        boolean[][] visited;
        int eat = 0;
        int size = 2;
        boolean isAte;
        do {
            // 2. 먹을 수 있는 물고기가 있는 가장 가까운 공간으로 이동(거리 우선)
            // 이동조건: 자신의 크기 >= 해당 공간의 물고기의 크기 -> 이동 가능
            // 먹기조건: 자신의 크기 > 해당 공간의 물고기 크기
            // 거리가 같은 먹을 수 있는 물고기가 여러개라면?
            // 2-1. 가장 위에 있는
            // 2-2. 가장 왼쪽에 있는 물고기
            visited = new boolean[N][N];
            pq.clear();
            isAte = false;
            pq.add(new Shark(start.y, start.x, 0));

            while (!pq.isEmpty()) {
                Shark curr = pq.poll();
                // System.out.printf("y=%d, x=%d, eat=%d, size=%d, result=%d, move=%d\n", curr.y, curr.x, eat, size, result, curr.move);
                // 3. 먹은 물고기 개수(eat) += 1
                // 4. 해당 위치 = 0 -> (0이 빈칸)
                // size = eat ? size += 1, eat = 0
                // 이동한 위치기 기준으로 다시 2~4번 반복
                if (graph[curr.y][curr.x] != 0 && size > graph[curr.y][curr.x]) {
                    graph[curr.y][curr.x] = 0;
                    eat++;
                    isAte = true;

                    if (eat == size) {
                        size++;
                        eat = 0;
                    }

                    result += curr.move;
                    start = new Shark(curr.y, curr.x, 0);
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = curr.y + dy[d];
                    int nx = curr.x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    if (visited[ny][nx] || size < graph[ny][nx]) continue;

                    pq.add(new Shark(ny, nx, curr.move + 1));
                    visited[ny][nx] = true;
                }
            }

        } while(isAte);

        return result;
    }
}
