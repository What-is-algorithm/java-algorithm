package silver.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO (1) 중복된 알파벳을 만났을 경우, 해당 방향은 더이상 탐색하지 않고 이전(이때, 직전일 수도 전전일 수도 있음) 루트로 돌아가서 재탐색 시작
// TODO (2) 얼마든지 이전 루트로 돌아가 재탐색을 시도해야하므로, 알파벳은 재귀가 벗겨질 때마다 방문에 대해 false 처리를 수행해야함

// TODO (1) 2차원 배열의 모든 값, 즉 알파벳을 탐색해야 함
// TODO (2) 상/하/좌/우 중 한 칸으로 이동
// TODO (3) 한 번 선택한 루트에 대해 중복한 알파벳을 만나기 전까지 끊임없는 탐색
public class ABC {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int r, c;
    private static int[][] board;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static boolean[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 1. board 입력 받기
        board = new int[r][c];
        board = getInput();

        // 2. 상/하/좌/우 탐색
        int alphabetNumber = 26;
        visited = new boolean[alphabetNumber];
        getResult();

        // 5. 출력
        System.out.println(result);
        br.close();
    }

    private static int[][] getInput() throws IOException {
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        return board;
    }

    // 4. 말이 지날 수 있는 최대의 칸 수 체크
    private static void getResult() {
        backtracking(0, 0, 1);
    }

    // 3. 이때, 같은 알파벳이 적힌 칸은 두 번 지날 수 없음
    private static void backtracking(int row, int column, int sumOfMaximumBlocks) {
        int presentAlphabet = board[row][column];
        visited[presentAlphabet] = true;
        result = Math.max(result, sumOfMaximumBlocks);

        int distance = 4;
        for (int i = 0; i < distance; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            // TODO r x c 배열을 기준으로 왼 -> 위 -> 오 -> 아래 변이 있다면..
            // nx >= 0: 왼쪽 변의 범위, nx < r: 오른쪽 변의 범위
            // ny >= 0: 위쪽 변의 범위, ny < c: 아랫쪽 변의 범위
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int nextAlphabet = board[nx][ny];

                if (!visited[nextAlphabet]) {
                    backtracking(nx, ny, sumOfMaximumBlocks + 1);

                    visited[nextAlphabet] = false;
                }
            }
        }
    }
}