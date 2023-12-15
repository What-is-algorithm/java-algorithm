package jin.setmap;

import java.io.*;
import java.util.*;

// [S4] 10816. 숫자 카드 2
public class 숫자카드2 {
    // 1512 ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        final int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int cnt = upperBound(target, arr) - lowerBound(target, arr);
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static int lowerBound(int target, int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;

            if (arr[m] >= target) {
                r = m;
            } else  {
                l = m + 1;
            }
        }
        return l;
    }

    private static int upperBound(int target, int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;

            if (arr[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;

    }
    // 1128 ms
    /*public static void case1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(num , 0)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }*/
}
