package silver.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC_2 {
    private static int r;
    private static int c;
    private static final int[] dx = {0, 1, 0, -1}; // 우하좌상
    private static final int[] dy = {1, 0, -1, 0};
    private static char[][] board;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        visited = new boolean[26];
        backtracking(0, 0, 1);
        System.out.println(result);
        br.close();
    }

    private static void backtracking(int row, int column, int sum) {
        int alphabet = board[row][column] - 'A';
        // TODO 탐색 범위를 줄이는 장치 1
        if (visited[alphabet]) {
            return;
        }

        // 문제를 작은 문제로 쪼개서 (나만의 방식으로)
        // 이전에 방문하지 않은 곳 방문 -> 방문처리 + 최대 길이 비교
        // ex. C -> A -> B => "처음에 방문했을 때, 비교하면 되지 않을까?"
        visited[alphabet] = true;
        result = Math.max(result, sum);
        // 방문하지 않은 곳을 어떻게 방문하는지 알고싶다 <-- 디버깅하겠죠

        int distance = 4;
        for (int i = 0; i < distance; i++) {
            int nx = row + dx[i]; // 우좌
            int ny = column + dy[i]; // 하상

            // TODO 탐색 범위를 줄이는 장치 2
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
//            System.out.printf("r=%d, c=%d, sum=%d, result=%d\n", row, column, result, sum); // 디버깅 참고.. 왜 여기서 할까?
                // result가 언제 바뀌는지 알고싶다.
                backtracking(nx, ny, sum + 1);
            }
        }

        visited[alphabet] = false; // FIXME: 1/29/24 얘가 여기가 맞아? (A -> false)
    }
}