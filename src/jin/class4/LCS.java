package jin.class4;

import java.io.*;

// [G5] 9251. LCS
public class LCS {
    // dp[N][M]
    // 비교하는 두 문자가 같다면 현재 문자가 LCS에 속하게 된다 -> 이전 LCS 길이에서 1을 더한다.
    // if s1.charAt(i) == s2.charAt(j) -> dp[i][j] = dp[i-1][j-1] + 1
    // 비교하는 두 문자가 다르면 현재 문자가 LCS에 속하지 않는다. -> 이전까지 LCS 중 더 긴 것 선택한다.
    // else -> dp[i][j] = max(dp[i-1][j], dp[i][j-1]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();

        int result = findLCSLength(str1, str2);

        System.out.println(result);
        br.close();
    }

    private static int findLCSLength(String str1, String str2) {
        final int N = str1.length();
        final int M = str2.length();

        int[][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[N][M];
    }
}