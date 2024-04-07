package jin.class4_2;

import java.io.*;
import java.util.*;

// 도시의 치킨 거리 중 최솟값
// nCm 조합 생성
// 경우의 수마다 도시의 치킨 거리 구하기 -> min(temp, min)
public class 치킨배달_15686 {

    static int N, M;
    static int[][] data;
    static List<int[]> houseList = new ArrayList<>();
    static List<int[]> chickenList = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 1) {
                    houseList.add(new int[]{i, j});
                } else if (data[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        backtracking(new ArrayList<>(), 0, 0);
        System.out.println(result);
    }

    private static void backtracking(List<int[]> selected, int depth, int start) {
        if(selected.size() == M) {
            getMinDistance(selected);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            int[] node = chickenList.get(i);
            selected.add(node);
            backtracking(selected, depth + 1, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static void getMinDistance(List<int[]> selected) {
        int dist = 0;
        for (int[] house : houseList) {
            int temp = Integer.MAX_VALUE;
            for (int[] store : selected) {
                temp = Math.min(temp, Math.abs(house[0] - store[0]) + Math.abs(house[1] - store[1]));
            }
            dist += temp;
        }

        result = Math.min(result, dist);
    }
}
