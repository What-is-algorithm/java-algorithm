package jin.class4;

import java.io.*;
import java.util.*;

// [S2] 11053. 가장 긴 증가하는 부분 수열
// N = 1000
// DP O(N^2) OK
// binary (NlogN) OK
public class 가장긴증가하는부분수열 {
    // binary -> 140ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        if (data.length == 1) {
            System.out.println(1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        list.add(data[0]);
        for (int num : data) {
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int idx = binarySearch(list, num);
                list.set(idx, num);
            }
        }

        System.out.println(list.size());
    }

    private static int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;

            if (list.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    // DP -> 152ms
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] data = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int tmp : dp) {
            maxLen = Math.max(tmp, maxLen);
        }

        System.out.println(maxLen);
        br.close();
    }*/
}
