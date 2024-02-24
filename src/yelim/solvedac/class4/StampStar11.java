package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StampStar11 {
    static String[] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N = 3 X 2^k (0 ≤ k ≤ 10)
        int N = Integer.parseInt(br.readLine());
        // 높이는 N이고 가로는 2N - 1
        // N = 1이면, 높이는 1이고 가로도 1
        // N = 3이면, 높이는 3이고 가로는 5

        // 별 기본 모양 저장 (k = 0)
        star = new String[N];
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";
        for(int i=1; 3 * Math.pow(2, i) <= N;i++) {
            stamp(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i < N;i++) {
            sb.append(star[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    //    0  1  2  3  4
    // 0 [ ][ ][*][ ][ ]
    // 1 [ ][*][ ][*][ ]
    // 3 [*][*][*][*][*]
    static void stamp(int i) {
        // 아래 최대 행
        int bottom = (int)(3 * Math.pow(2, i));
        // 위 아래를 구분하는 행
        int middle = bottom / 2;

        // 아래 부분에 대응하는 별 점화식 적용
        for(int j=middle;j < bottom;j++) {
            star[j] = star[j - middle] + " " + star[j - middle];
        }

        String blank = " ".repeat(middle);

        // 윗 부분에 대응하는 별 점화식 적용
        for(int j=0;j < middle;j++) {
            star[j] = blank + star[j] + blank;
        }
    }
}
// https://tussle.tistory.com/1000