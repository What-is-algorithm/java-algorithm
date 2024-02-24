package yelim.solvedac.class4;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class GoingDown {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N(1 ≤ N ≤ 100,000)줄에 0 이상 9 이하의 숫자가 세 개씩 -> 첫번째 줄에서 마지막 줄까지 내려가기
        // 다음 줄로 내려갈 때, 바로 아래 수로 가거나 바로 아래 수와 붙어 있는 수로만 이동 가능
        // 내려가면서 숫자 누적하기
        // 내려가기 게임을 했을 때, 숫자 누적이 최대인 것과 최소인 것을 출력
        // dp로만 풀기에는... 제한 메모리가 4MB...
        // -> 슬라이딩 윈도우 알고리즘 : 일정 범위를 가지고 있는 것을 유지하면서 이것을 이동하는 것

        int N = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3]; // 최대 값으로 저장할 dp 테이블
        int[] minDp = new int[3]; // 최소 값으로 저장할 dp 테이블

        for (int i=0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int x2 = Integer.parseInt(input[1]);
            int x3 = Integer.parseInt(input[2]);

            if(i == 0) { // 첫 줄은 값을 그대로 넣어주기
                maxDp[0] = minDp[0] = x1;
                maxDp[1] = minDp[1] = x2;
                maxDp[2] = minDp[2] = x3;
            } else {
                // 원래 가진 값을 유지하기 위해 변수에 담아둔다.
                int beforeMaxDp0 = maxDp[0], beforeMaxDp_2 = maxDp[2];
                // 인덱스가 0이면 1이나 2인 인덱스 값을 보고
                maxDp[0] = Math.max(maxDp[0] , maxDp[1]) + x1;
                // 인덱스가 2이면 1이나 2인 인덱스 값을 보고
                maxDp[2] = Math.max(maxDp[1] , maxDp[2]) + x3;
                // 인덱스가 1이면 0이나 1, 2인 인덱스 값을 보기, 가장 많이 비교하는 maxDp[1]을 제일 마지막에 하기
                maxDp[1] = Math.max(Math.max(beforeMaxDp0, maxDp[1]) , beforeMaxDp_2) + x2;

                int beforeMinDp0 = minDp[0], beforeMinDp_2 = minDp[2];
                minDp[0] = Math.min(minDp[0] , minDp[1]) + x1;
                minDp[2] = Math.min(minDp[1] , minDp[2]) + x3;
                minDp[1] = Math.min(Math.min(beforeMinDp0, minDp[1]) , beforeMinDp_2) + x2;

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]))).append(" ").append(Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
        System.out.println(sb);
        br.close();
    }
}
// https://steady-coding.tistory.com/154