package silver.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 초기화
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        // 2. 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < card.length; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] countNumber = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < countNumber.length; i++) {
            countNumber[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 정렬
        Arrays.sort(card);

        // 4. 탐색
        for (int i = 0; i < countNumber.length; i++) {
            System.out.println(getUpperIndex(card, countNumber[i]) - getLowerIndex(card, countNumber[i]) + " ");
        }

        br.close();
    }

    /*
     * 값의 개수 구하기 (단, 중복 원소를 고려해야 함)
     * l : 최소 인덱스
     * r : 최대 인덱스 (이때, 전체 배열 길이 그대로)
     * m : 찾고자 하는 값의 인덱스
     * lower bound(= 하한 값) : 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
     * upper bound(= 상한 값) : 찾고자 하는 값을 초과한 값을 처음 만나는 위치
     * target <= middle, upper bound = middle
     * target > middle, lower bound = m + 1
     */

    // 추후, 이진 탐색 내부의 if()에 메서드를 선언하여 갈라지는 형식으로 리팩토링 예정
    private static int getUpperIndex(int[] card, int target) {
        int l = 0;
        int r = card.length;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (target < card[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static int getLowerIndex(int[] card, int target) {
        int l = 0;
        int r = card.length;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (target <= card[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
