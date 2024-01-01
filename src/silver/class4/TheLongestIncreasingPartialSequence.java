package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Todo LIS(Longest Increasing Subsequence) : 가장 긴 증가하는 부분 수열
// Todo 연속적으로 값이 증가하는 부분에 대해 수열을 구하는 것이 아니라, 각각의 element에 대해 해당 element보다 인덱스가 작은 모든 element에 대해 비교
// Todo 이때 3번째 원소에 대해 dp를 진행한다면 1, 2번째 원소에 대해 비교를 수행
// Todo 그리고 3번째 원소와 비교했을 때, 1, 2번째 원소 중 작은 값이 있다면 dp ++

// Todo 반례 : 6 / 4 1 2 3 4 5

// Todo 아래의 풀이가 왜 틀릴까요?
public class TheLongestIncreasingPartialSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n]; // dp 테이블 선언 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 모든 dp 값들은 최소 1
        }

        int max = 1;

        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < n - 1; j ++) {
                if (arr[i] > arr[j]) { // 재 element가 다른 element들 보다 크다면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 전 element들 중 가장 큰 dp 값 + 1
                }
            }

            max = Math.max(max, dp[i]); // LIS 길이 구하기
        }

        System.out.println(max);
        br.close();
    }
}
