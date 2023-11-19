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
        이진 탐색
        (1) @param 정렬된 배열(= arr)
        (2) @param 찾으려는 값(= key)
        (3) @return key와 일치하는 배열의 인덱스
        */

        // 4. 탐색
        for (int i = 0; i < elements.length; i++) {
            System.out.println(getIndex(standards, elements[i]));
        }

        br.close();
    }

    private static int getIndex(int[] standards, int target) {
        int l = 0; // ※ 최솟값은 0
        int r = standards.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (target == standards[m]) return 1;
            if (target < standards[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return 0;
    }
}
