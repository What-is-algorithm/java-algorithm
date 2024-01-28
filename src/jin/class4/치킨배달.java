package jin.class4;

import java.io.*;
import java.util.*;

// [G5] 15686. 치킨 배달
public class 치킨배달 {
    static int result = Integer.MAX_VALUE;
    // r과 c는 1부터 시작한다.
    // 집이 있는 리스트
    // 치킨 집이 있는 리스트
    // 치킨 집이 있는 리스트의 크기
    // 배열 크기 new int[M]
    // temp -> int[M] -> 치킨집이 있는 곳의 idx
    // for (M) -> 각각의 집들이 치킨집과의 거리중 최솟값을 계산 -> 앞에서의 계산을 모으면 도시의 치킨거리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][N];
        List<int[]> houses = new ArrayList<>();
        List<int[]> chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 1) {
                    houses.add(new int[] {i, j} );
                } else if (data[i][j] == 2) {
                    chickens.add(new int[] {i, j});
                }
            }
        }

        selectChickens(chickens, houses, 0, 0, new int[M], M);
        System.out.println(result);
        br.close();
    }

    private static void selectChickens(List<int[]> chickens, List<int[]> houses, int start, int cnt, int[] temp, int M) {
        if (cnt == M) {
            result = Math.min(result, getCityChickenDistance(chickens, houses, temp));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            temp[cnt] = i;
            selectChickens(chickens, houses, i + 1, cnt + 1, temp, M);
        }
    }

    private static int getCityChickenDistance(List<int[]> chickens, List<int[]> houses, int[] selected) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int idx : selected) {
                int[] chicken = chickens.get(idx);
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }

            totalDistance += minDistance;
        }

        return totalDistance;
    }
}