package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strSequence1 = br.readLine();
        String strSequence2 = br.readLine();

        int[][] dp = new int[strSequence1.length() + 1][strSequence2.length() + 1];

        for (int i = 1; i <= strSequence1.length(); i++) {
            for (int j = 1; j <= strSequence2.length(); j++) {
                if (strSequence1.charAt(i - 1) == strSequence2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[strSequence1.length()][strSequence2.length()]);
        br.close();
    }
}
