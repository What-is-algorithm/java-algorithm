package jin.class4_2;

import java.util.*;

public class LCS_9251 {

    static String s1, s2;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine().trim();
        s2 = sc.nextLine().trim();

        int n = s1.length(), m = s2.length();
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]);
        sc.close();
    }
}
