package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//class Pair {
//    int r, c; // cmd + n
//
//    public Pair(int r, int c) {
//        this.r = r;
//        this.c = c;
//    }

    // Todo 객체를 문자열로 변환하여 출력하기 위해서는 toString() 메서드를 오버라이딩 해야 함
//    @Override
//    public String toString() {
//        return "(" + r + ", " + c + ")";
//    }
// }

public class SumOfIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int[] ints : board) {
//            System.out.println(Arrays.toString(ints));
//        }

        System.out.println();

        // 2 2 3 4 -> (2, 2) (3, 4)로 묶을 좋은 방법이 무엇이 있을까?
        // 역시 HashMap일까? -> 아 근데 key는 덮여씌워지는구나..
        // Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                // Todo human issue
                dp[i][j] = board[i][j] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }

//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }

        // Todo m개의 줄에는 네 개의 정수가 주어진다.
        // Todo 원래 생각한 방향 : m개의 줄에 걸쳐 좌표를 받아옴 -> 이때, 한 행별로 주어진 좌표를 기준으로 dp 배열을 채워서 값을 도출
        // Todo but, 이럴 경우 m이 100,000일 경우 100,000 줄에 걸쳐서 (n = 1024일 경우) (1024, 1024)의 값이 주어졌다면
        // Todo (1024, 1024)의 값을 구하기 위해 (1, 1)부터 dp 배열을 매번 탐색해서 값을 누적시켜야 함
        // Todo 따라서 시간 복잡도 측면에서 1초(= 100,000,000)을 훌쩍 넘기게 됨
        // Todo 수정한 방향 : board 배열의 값을 받아옴 -> dp 배열 초기화 -> m개의 줄에 걸쳐 좌표를 받아온 후, dp 탐색
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // Todo 기존 값을 활용해서 값을 가져오려는 것이므로 재할당이 아닌, 바로 출력용 StringBuilder에 추가
            sb.append(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]).append("\n"); // cmd + x 이슈
        }

        System.out.println(sb);
        br.close();
    }
}

// for (int i = 1; i <= n; i ++) {
//      for (int j = 1; j <= n ; j ++) {
//          if (j == 1) {
//              board[i][j] = board[i - 1][n];
//          }
//      }
// }