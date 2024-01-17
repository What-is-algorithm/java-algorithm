package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Todo 백트래킹 : 가능성이 있는 노드에 대해 경우의 수를 찾는 것
// Todo 브루트포스 : 모든 경우의 수를 찾는 것
// Todo DP : 백트래킹에 사용하는 대표 탐색 알고리즘, (ex.dfs, 백트래킹의 방법 중 하나)

// Todo : 퀸이 이동할 수 있는 위치 -> 상/하/좌/우 + 대각선
// Todo : "어떠한 수를 depth 즉 깊이로 두고 풀 것인가"
public class NQueen {
    private static int[] arr;
    private static int n;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);
        System.out.println(count);
    }

    // Todo : depth = 체스판의 행 (ex. arr[depth] -> index = depth = row)
    // Todo : value = 체스판의 열 (ex. arr[depth] = column)
    // Todo : 2차원 배열 -> 모든 행과 열을 탐색
    // Todo : 1차원 배열 -> (1) 39L 라인과 47L을 통해 행과 열을 탐색하기 때문, (2) 1차원 배열로도 풀 수 있기 때문 <-> 2차원으로 푼다면 어떻게 풀까?
    // 1차원 배열로 풀었을 때는 i만 바뀌면 되지만, 2차원 배열로 풀었을 경우에는 i와 j가 모두 업데이트 되어야 할 것
    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i; // arr의 인덱스 : 행 (= depth), arr의 값 : 열 (= i)
            if (possible(depth)) { // Queen이 있어도 되는 자리인지
                dfs(depth + 1);
            }
        }
    }

    private static boolean possible(int column) {
        for (int i = 0; i < column; i ++) {
            if (arr[i] == arr[column]) { // Queen이 같은 열에 있다면
                return false;
            }

            else if (Math.abs(column - i) == Math.abs(arr[column] - arr[i]))  { // Queen이 대각선에 있다면(= 행 - 열)
                return false;
            }
        }

        return true;
    }
}
