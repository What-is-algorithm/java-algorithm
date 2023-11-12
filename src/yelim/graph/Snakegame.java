package yelim.graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Snakegame {
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        // 사다리
        int n = Integer.parseInt(str[0]);
        // 뱀
        int m = Integer.parseInt(str[1]);

        // 게임 판
        board = new int[101];
        // 인덱스 번호를 원소 값으로 하기
        for (int i = 1; i < board.length; i++) {
            board[i] = i;
        }

        // 사다리
        while (n-- > 0) {
            String[] ldr = br.readLine().split(" ");

            int x = Integer.parseInt(ldr[0]);
            int y = Integer.parseInt(ldr[1]);

            board[x] = y;
        }
        // 뱀
        while (m-- > 0) {
            String[] snake = br.readLine().split(" ");

            int x = Integer.parseInt(snake[0]);
            int y = Integer.parseInt(snake[1]);

            board[x] = y;
        }


        int result = bfs(1);
        System.out.println(result);

    }

    private static int bfs(int startNode) {
        int[] check = new int[101]; // 방문 순서를 기록하기 위한 배열 생성
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode); // 처음에 인덱스 1이 넣기
        check[startNode] = 0;

        while (true) {
            int visitedNum = q.poll();
            // 주사위 1 ~ 6이 나오는 경우
            for (int i = 1; i < 7; i++) {
                int newNode = visitedNum + i;

                // board의 범위를 넘기면 무시
                // check 배열에 IndexOutOfBoundsException을 발생시킬 수 있기 때문이다.
                if (newNode > 100) {
                    continue;
                }

                // check 배열에 아직 방문한 적 없는 0이라면
                if (check[board[newNode]] == 0) {
                    q.offer(board[newNode]);
                    check[board[newNode]] = check[visitedNum] + 1;
                }
                // 100까지 도착했으면
                if (board[newNode] == 100) {
                    return check[100];
                }
            }

        }

    }
}
