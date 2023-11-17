package jin.binarysearch;

import java.io.*;
import java.util.*;
// [S2] 2805. 나무 자르기
// 시작값=1, 끝값=배열의 최댓값 탐색 시작
// mid 탐색으로 인한 rest == M return mid
// rest >= M ? start = mid + 1
// rest < M ? end = mid - 1;
public class 나무자르기 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxNum = 0;
        for (int num : arr) {
            maxNum = Math.max(num, maxNum);
        }

        System.out.println(binarySearch(maxNum));
        br.close();
    }

    private static int binarySearch(int maxNum) {
        int start = 1;
        int end = maxNum;

        while (start <= end) {
            int mid = (start + end) / 2;
            long rst = checkLength(mid);

            if (rst >= M) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }

    private static long checkLength(int length) {
        long rest = 0;
        for (int num : arr) {
            rest += num > length ? num - length : 0;
        }
        return rest;
    }
}
