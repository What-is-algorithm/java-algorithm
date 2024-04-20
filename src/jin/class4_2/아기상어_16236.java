package jin.class4_2;

import java.util.*;
import java.io.*;

public class 아기상어_16236 {

    static int N;
    static int[][] data;
    static int result = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        int sy = 0, sx = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 9) {
                    sy = i;
                    sx = j;
                    data[i][j] = 0;
                }
            }
        }
        br.close();
        bfs(sy, sx);
        System.out.println(result);
    }

    private static void bfs(int sy, int sx) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int eat = 0, size = 2;
        boolean isAte;
        boolean[][] visited;

        do {
            visited = new boolean[N][N];
            pq.clear();
            isAte = false;
            pq.add(new Node(sy, sx, 0));

            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                // 방문한 칸 해당 칸 = 0 할당
                // 크기보다 작거나 먹고 += 1
                if (data[curr.y][curr.x] > 0 && size > data[curr.y][curr.x]) {
                    data[curr.y][curr.x] = 0;
                    eat++;
                    isAte = true;

                    // 자신의 크기만큼 먹었으면 크기 += 1
                    if (eat == size) {
                        size++;
                        eat = 0;
                    }

                    result += curr.move;
                    sy = curr.y;
                    sx = curr.x;
                    break;
                }

                // 상 좌 하 우 이동. 크기가 작거나 같을 때 이동
                for (int d = 0; d < 4; d++) {
                    int ny = curr.y + dy[d];
                    int nx = curr.x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    if (visited[ny][nx] || size < data[ny][nx]) continue;

                    pq.add(new Node(ny, nx, curr.move + 1));
                    visited[ny][nx] = true;
                }
            }
        } while (isAte);
    }


        static class Node implements Comparable<Node> {
            int y, x, move;

            public Node(int y, int x, int move) {
                this.y = y;
                this.x = x;
                this.move = move;
            }

            @Override
            public int compareTo(Node other) {
                return this.move != other.move ? Integer.compare(this.move, other.move)
                        : this.y != other.y ? Integer.compare(this.y, other.y)
                        : Integer.compare(this.x, other.x);
            }
        }
    }
