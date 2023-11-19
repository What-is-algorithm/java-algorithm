package silver.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 초기화
        int n = Integer.parseInt(br.readLine());
        int[] standards = new int[n];

        // 2. 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < standards.length; i++) {
            standards[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] elements = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < elements.length; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 정렬
        Arrays.sort(standards);

        /*
        1. 무엇을 찾고자 하는지?
        -> m개의 수가 담긴 배열(= element)의 수들이 n개의 수가 담긴 배열에 있는지
        2. 이진 탐색에서 무엇을 기준으로 찾고자 하는지?
        -> n개의 수가 담긴 배열에서 원소의 인덱스
        ex) standard = [1, 2, 3, 4, 5] 중 3이 있는지?
        (1) l = 0, r = 4
        (2) m = 2
        (3) 1 == 3? --> x
        (4) 1 < 3? --> x
        (5) 1 > 3 --> o
        (5) l = 0, r = 1
        ..
        */

        // 4. 탐색
        for (int i = 0; i < elements.length; i ++) {
            System.out.println(getIndex(standards, elements[i]));
        }

        br.close();
    }

    private static int getIndex(int[] standards, int target) {
        int l = 0; // ※ 최솟값은 0
        int r = standards.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (standards[m] == target) return 1;
            if (standards[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return 0;
    }
}
