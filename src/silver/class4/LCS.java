package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Todo Longest Common Subsequence : 최장 공통 부분 수열
// <-> LIS(Longest Increasing Subsequence) : 가장 긴 증가하는 부분 수열
// Todo (중요) 접근법부터 확인 -> (이해가 안 되었다면) 설명 -> (이해가 안 되었다면) 그림을 확인 -> 다른 포스팅을 확인 -> 3~4개의 포스팅을 보고도 이해가 안 되었다면 코드로 보기 확인하기
public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력부터 다 처리해놓고 고민할래~
        String strSequence1 = br.readLine();
        String strSequence2 = br.readLine();

        // Todo 두 문자열을 가져와서 문자를 하나씩 비교해야겠지?
        // Todo 이때, 예제 입력 1을 기준으로 생각한다면..
        // Todo n x n 크기의 정사각형에서 각 열을 채울 때 같은 원소가 있다면, 이전 열 또는 행에 +1한 값이 LCS 길이가 되고 이를 계속 누적해서 이어나가는 식

        // Todo (중요) dp 안의 데이터는 뭘 다루고 있을까?
        // (1) "출력값"을 보자. -> dp 안에는 "LCS의 길이"가 들어가네 -> "두 인덱스"를 이용해서 LCS의 길이를 저장할 것이다. -> "i, j"
        // (2) i, j 는 무엇일까?

        // dp 안에는 LCS의 길이를 저장
        // Todo dp는 1차원일까? 2차원일까? -> LCS의 길이 -> 같은 문자를 두 문자열이 공통으로 가지고 있을 때의 길이
        // Todo 이때 공통 문자는 연속적일 필요가 없음, 각각 두 문자열의 모든 문자를 탐색해야 함
        // Todo 두 문자열의 모든 문자를 탐색하려면 2차원 배열을 써야한다?
        // Todo -> 두 문자열의 마지막 문자를 비교해서 일치하는지를 확인
        // ex. i = 0 -> A 와 C를 비교, i = 1 -> A, C에 대해서 C를 비교 -> i = 2 -> A, C, A에 대해서 C를 비교

        int[][] dp = new int[strSequence1.length() + 1][strSequence2.length() + 1];
//        if (strSequence1.charAt(0) == strSequence2.charAt(0)) {
//            dp[0][0] = 1;
//        }
//
//        for (int i = 1; i < strSequence2.length(); i ++) {
//            if (strSequence1.charAt(0) == strSequence2.charAt(i)) {
//                dp[0][i] = 1;
//            } else {
//                dp[0][i] = Math.max(dp[0][i], dp[0][i - 1]);
//            }
//        }
//
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//
//        System.out.println();
//
//        for (int i = 1; i < strSequence1.length(); i ++) {
//            if (strSequence1.charAt(i) == strSequence2.charAt(0)) {
//                dp[i][0] = 1;
//            } else {
//                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
//            }
//        }
//
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }

//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }

//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//
//        System.out.println();

        for (int i = 1; i <= strSequence1.length(); i ++) {
            for (int j = 1; j <= strSequence2.length(); j ++) {
                if (strSequence1.charAt(i - 1) == strSequence2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 헉; 내가 이걸 쓰다니... 맨날 베꼈는데..
                }
            }
        }

        System.out.println(dp[strSequence1.length()][strSequence2.length()]);
        br.close();
    }
}
