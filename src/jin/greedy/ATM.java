package jin.greedy;

import java.io.*;
import java.util.*;

// [S4] 11399. ATM
public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));

        int[] dp = new int[N];
        dp[0] = arr[0];
        int rst = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + arr[i];
            rst += dp[i];
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(rst);
        br.close();
    }
}