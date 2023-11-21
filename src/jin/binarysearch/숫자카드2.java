package jin.binarysearch;

import java.io.*;
import java.util.*;

// [S4] 10816. 숫자 카드 2
public class 숫자카드2 {
    static int N;
    static int[] arrN;
    static int M;
    static int[] arrM;
     static Map<Integer, Integer> map;

     // 1168 ms
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : arrM) {
            int left = loweBound(num);
            int right = upperBound(num);
            sb.append(right - left).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static int loweBound(int target) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arrN[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private static int upperBound(int target) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arrN[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }*/

    // 1700 ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        map = new HashMap<>();
        for (int n : arrN) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

//        System.out.println(map);

        for (int m : arrM) {
            sb.append(map.getOrDefault(m, 0)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}