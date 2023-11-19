package silver.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CableCutting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 초기화
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cables = new int[k];

        // 2. 입력
        for (int i = 0; i < cables.length; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        // 3. 정렬
        Arrays.sort(cables);

        // 4. 출력
        System.out.println(MaxCableLength(cables, n));
        br.close();
    }

    /*
    parametric search = 이분 탐색을 응용한 최솟값 또는 최댓값 구하기
    -> 만들 수 있는 랜선의 최대 길이 구하기
    * l : 자를 랜선의 최소 길이
    * r : 자를 랜선의 최대 길이
    * m : 자를 랜선의 중간 길이
    */

    private static long MaxCableLength(int[] cables, int target) {
        long l = 0;
        long r = cables[cables.length - 1]; // 이번엔 배열 내에 원소가 위치한 인덱스가 아니라 배열의 원소를 이용하여 특정 값 자체를 구하는 것
        long maxLength = 0;

        while (l <= r) {
            long m = l + (r - l) / 2;
            int cableCnt = 0;

            for (int i = 0; i < cables.length; i ++) {
                cableCnt += (cables[i] / m);
            }

            if (target == cableCnt) {
                maxLength = m;
                return maxLength;
            }
            if (target < cableCnt) {
                // 목표 개수가 자른 케이블의 개수보다 작다면
                // 랜선을 작게 작게 잘랐다는 것 = 자를 랜선의 길이를 늘려야 함
                maxLength = m;
                l = m + 1;
            } else {
                r = m - 1; // target > cableCnt
            }
        }

        return maxLength;
    }
}
