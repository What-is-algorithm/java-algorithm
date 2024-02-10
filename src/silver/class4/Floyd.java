package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO "X -> Y로 가는 최소 비용 vs X에서 노드 1로 가는 비용 + 노드 1에서 Y로 가는 비용"
// TODO 1: 도시의 개수(n), 2: 버스의 개수(m), 3 ~ m + 2: 버스의 정보(시작 도시, 도착 도시, 한 번 타는데 필요한 비용)
// TODO 시작 도시 -> 도착 도시로 가는 방법을 여러개 -> a와 b가 같을 수 있음 -> 받아서 정렬
// TODO (i, j) : i에서 j로 가는데 필요한 최소 비용
// TODO 플로이드 : 모든 정점에서 모든 정점까지의 최단 경로(= 최소 비용) -> 2차원 배열 + 3중 for문
// TODO 도시 : 노드, 버스 : 간선

public class Floyd {
    // TODO int 형은 약 21억의 값을 가지기 때문에, 10억 정도의 값만 넣어줘도 무한을 표현할 수 있음
    private static int INF = 1_000_000_000; // Integer.MAX_VALUE = 2_147_483_647 -> 스택 오버 플로우, 단 로직에 따라 스택 오버 플로우가 발생하지 않을 수도 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNumber = Integer.parseInt(br.readLine());
        int bufNumber = Integer.parseInt(br.readLine());

        // 1. 도시 배열 초기화
        int[][] board = new int[cityNumber + 1][cityNumber + 1]; // 모든 도시에서 모든 도시까지의 최단 경로이므로 2차원 배열

        for (int i = 1; i <= cityNumber; i++) {
            for (int j = 1; j <= cityNumber; j++) {
                board[i][j] = INF; // 모든 도시의 비용을 무한으로 설정

                if (i == j) {
                    board[i][j] = 0; // j에서 j로 갈 수 없는 경우, 즉 i와 j가 같을 경우 0
                }
            }
        }

        // 2. 현재까지 계산된 최소 비용
        for (int i = 0; i < bufNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int arriveCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            board[startCity][arriveCity] = Math.min(board[startCity][arriveCity], cost); // 출발 도시와 도착 도시가 같지만, 더 적은 비용이 드는 루트를 선택해야 함
        }

        // 3. 플로이드 워셜 알고리즘
        for (int k = 1; k <= cityNumber; k++) { // 출발 도시 -> 도착 도시의 비용 vs 출발 도시 -> 경유 도시 -> 도착 도시의 비용
            for (int i = 1; i <= cityNumber; i++) {
                for (int j = 1; j <= cityNumber; j++) {
                    if (board[i][j] > board[i][k] + board[k][j]) {
                        board[i][j] = board[i][k] + board[k][j];
                    }
                }
            }
        }

        // 3. 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= cityNumber; i++) {
            for (int j = 1; j <= cityNumber; j++) {
                if (board[i][j] == INF) {
                    board[i][j] = 0; // 갈 수 없는 곳은 0으로 출력해야하므로 초기화
                }

                sb.append(board[i][j] + " "); // 출력 시, 한 행에 최소 비용 간에 공백이 존재
            }

            sb.append("\n"); // ex. (1, 1) (1, 2) .. (n, n) -> (2, 1) (2, 2) .. (n, n)
        }

        System.out.println(sb);
        br.close();
    }
}
