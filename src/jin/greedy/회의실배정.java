package jin.greedy;

import java.io.*;
import java.util.*;

// [S1] 1931. 회의실 배정
// 종료 시간 기준 정렬 vs 시작시간 기준 정렬 oops...
// 종료 시간 기준 정렬 후 같으면 시작 시간으로 정렬
public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (arr1, arr2) -> {
            if (arr1[1] == arr2[1]) {
                return Integer.compare(arr1[0], arr2[0]);
            } else {
                return Integer.compare(arr1[1], arr2[1]);
            }
        });

//        for (int[] a : arr) {
//            System.out.println(Arrays.toString(a));
//        }

        int end = arr[0][1];
        int rst = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                rst++;
            }
        }

        System.out.println(rst);
    }
}
