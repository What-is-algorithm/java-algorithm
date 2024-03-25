package jin.class4_2;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열_11053 {

    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int result = 0;
        for(int num : dp) {
            result = Math.max(result, num);
        }

        System.out.println(result);
        br.close();
    }
}
