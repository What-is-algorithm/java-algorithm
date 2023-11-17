package jin.binarysearch;

import java.io.*;
import java.util.*;

// [G4] 2110. 공유기 설치
// 배열 오름차순 정렬
// 이진 탐색 반복 while (start <= end)
// 위 while문 안에서 for (1, N) 안에 router, cnt 설정.
// arr[i] >= router + mid -> router 갱신, cnt++.
// cnt >= C start = mid + 1;
// cnt < c end = mid - 1;
public class 공유기설치 {
    static int N;
    static int C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int start = 1;
        int end = arr[arr.length-1];
        int rst = 0;

        while (start <= end) {
            int router = arr[0];
            int cnt = 1;
            int mid = (start + end) / 2;

            for (int i = 1; i < N; i++) {
                if (arr[i] >= router + mid) {
                    cnt++;
                    router = arr[i];
                }
            }

            if (cnt >= C) {
                start = mid + 1;
                rst = mid;
            } else {
                end = mid - 1;
            }
        }
        return rst;
    }
}
