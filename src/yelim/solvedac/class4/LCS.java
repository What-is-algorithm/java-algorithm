package yelim.solvedac.class4;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] oneArr = br.readLine().toCharArray();
        char[] twoArr = br.readLine().toCharArray();

        // 부분 수열에서 순서가 지켜진다. -> 각 문자열의 문자들을 비교하면서 서로 같으면 값을 1씩 중가하여 누적합 구하기
        // 부분 수열에 대한 길이 값을 채워나가는 것
        // 공집합 표현을 위해 인덱스 한 줄씩 추가
        // 각각의 행과 열이 무엇을 의미하는지...
        int[][] dp = new int[oneArr.length + 1][twoArr.length + 1];

        //     C A P C A K
        //   0 0 0 0 0 0 0
        // A 0 0 1 1 1 1 1
        // C 0 1 1 1 2 2 2
        // A 0 1 2 2 2 3 3
        // Y 0 1 2 2 2 3 3
        // K 0 1 2 2 2 3 4
        // P 0 1 2 3 3 3 4

        // 인덱스가 LCS 길이를 의미
        // 공집합이 없다고 생각하고 인덱스 (1, 0)는 {A, C}, {C}의 길이를 의미하고 인덱스 (1, 0)의 값인 1은 공통 원소가 1개라는 것
        for(int i=1;i <= oneArr.length;i++) {
            for(int j=1;j <= twoArr.length;j++) {
                // 문자가 서로 같다면 (이전 행, 이전 열)의 누적합에서 +1
                // 공통 원소가 추가되었으므로
                if(oneArr[i - 1] == twoArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else { // 같지 않으면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[oneArr.length][twoArr.length]);
        br.close();
    }
}
// https://st-lab.tistory.com/139