package silver.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeCutting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 초기화
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];

        // 2. 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 정렬
        Arrays.sort(tree);

        // 4. 탐색
        System.out.println(getMaxTreeLength(tree, m));
        br.close();
    }

    /*
     * "절단기"에 설정할 수 있는 높이의 최댓값 구하기
     * = 나무 길이 ∝ 1 / 절단기의 길이(높이)
     * m (구하고자 하는 값) : 절단기의 길이(값)
     * 절단기에 잘린 나무 길이(treeLengthSum)를 통해 절단기의 높이(m)를 구해야 함
     * = 가져가고자 하는 나무의 길이(M)보다 treeLengthSum이 작다면, m은 커져야 함
     * 반대로, 가져가고자 하는 나무의 길이(M)보다 treeLengthSum이 크다면, m은 작아져야 함
     *
     * lower bound(= 하한 값) : 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
     */

    private static long getMaxTreeLength(int[] tree, int target) {
        long l = 1;
        long r = tree[tree.length - 1];
        long maxLength = 0; // 절단기의 최대 길이

        while (l <= r) {
            long m = l + (r - l) / 2;
            long treeLengthSum = 0;

            for (int i = 0; i < tree.length; i++) {
                if (tree[i] >= m) {
                    treeLengthSum += tree[i] - m;
                }
            }

            if (target <= treeLengthSum) {
                // 목표 길이가 집에 가져가려는 나무의 길이보다 작다면
                // 나무를 너무 많이 잘랐다는 것 = 절단기의 길이가 짧다는 것 -> 절단기의 길이를 높여야 함
                maxLength = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return maxLength;
    }
}
