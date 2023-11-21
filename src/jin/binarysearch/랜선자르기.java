package jin.binarysearch;

import java.io.*;
import java.util.*;

// [S2] 1654. 랜선 자르기
// 시작값=1, 끝값=배열의 최댓값 이분탐색 시작
// for cnt += 값/mid
// cnt >= M ? start = mid + 1 -> 개수가 많다는 것은 짧게 짤랐다는 의미
// cnt < M ? end = mid - 1 -> 개수가 적다는 것은 길게 짤랐다는 의미
// 상한은 찾고자 하는 특정 값을 초과하는 '첫 위치'를 반환한다. -> 최댓값 구하기 최적화 return start - 1;
// 하한은 찾고자 하는 특정 값 이상인 '첫 위치'를 반환한다. -> 최솟값 구하기 최적화 return start;
public class 랜선자르기 {
    static int K;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];

        long r = 0;

        // 입력과 동시에 해당 랜선의 길이가 최댓값인지를 확인하고 max를 갱신
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(r < arr[i]) {
                r = arr[i];
            }
        }


        // 반드시 max에서 +1 값이어야 한다.
        r++;

        long l = 0;
        long mid = 0;

        while (l < r) {

            // 범위 내에서 중간 길이를 구한다.
            mid = (r + l) / 2;


            long count = 0;

            // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.

            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            /*
             *  upper bound
             *  mid길이로 잘랐을 때 개수 < 만들고자 하는 랜선의 개수 -> 많이 잘랐음 -> r = mid;
             *  mid길이로 잘랐을 때 개수 >= 만들고자 하는 랜선의 개수 -> 짧게 잘랐음 -> l = mid+1;
             */
            if(count < N) r = mid;
            else l = mid + 1;

        }
        System.out.println(l - 1);
    }
}