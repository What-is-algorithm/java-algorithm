package jin.binarysearch;

import java.io.*;
import java.util.*;

// [S2] 1654. 랜선 자르기
// 시작값=1, 끝값=배열의 최댓값 이분탐색 시작
// for cnt += 값/mid
// cnt >= M ? start = mid + 1 -> 개수가 많다는 것은 짧게 짤랐다는 의미
// cnt < M ? start = end - 1 -> 개수가 적다는 것은 길게 짤랐다는 의미
public class 랜선자르기 {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxNum = 0;

        for (int num : arr) {
            maxNum = Math.max(num, maxNum);
        }

        int result = binarySearch(maxNum);
        System.out.println(result);
        br.close();
    }

    private static int binarySearch(int maxNum) {
        int start = 1;
        int end = maxNum;
        // 조건을 충족하는 랜선이 하나 이상임 -> 최댓값을 저장
        int rst = end;

        while (start <= end) {
            long cnt = 0;
            int mid = (start + end) / 2;

            for (int num : arr) {
                cnt += num / mid;
            }

            if (cnt >= M) {
                start = mid + 1;
                rst = end;
            }
            else end = mid - 1;
        }

        return rst;
    }
}
