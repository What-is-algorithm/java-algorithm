package yelim.solvedac.class4;

public class ClimbingStairs_Leetcode {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
    static int climbStairs(int n) {
        // 1 <= n <= 45
        // O(N)
        // (1칸 전 경우 + 1칸) + (2칸 전 경우 + 2칸)
        // EX. 4 계단
        // 1칸 전인 3 계단 -> (1칸+1칸+1칸, 2칸+1칸, 1칸+2칸) + 1칸
        // 2칸 전인 2 계단 -> (1칸+1칸, 2칸) + 2칸
        int[] dp = new int[n+1];
        dp[1] = 1;

        if(n > 1) dp[2] = 2;

        for(int i=3;i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
