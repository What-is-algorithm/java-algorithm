package jin.binarysearch;

import java.io.*;
import java.util.*;

// [G1] 1300. K번째 수
// N * N의 배열은 만들 필요가 없다. -> 이중 for문을 통해 value를, idx++를 통해 index를 넣어 int[] 만들기 -> 오름차순 정렬 -> 인덱스 탐색
// 특정 인덱스의 값 구하기
// 풀이 생각이 안나는 문제...
// 1. 인덱스의 값 <= 인덱스의 value. (arr[idx] = i * j)
// 2.
public class K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int K = Integer.parseInt(br.readLine());

//        searchArr(N, K);
    }

    private static void searchArr(int n, int k) {
        int[] arr = new int[n * n + 1];
        int idx = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[idx++] = i * j;
            }
        }

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[k]);
    }
}
