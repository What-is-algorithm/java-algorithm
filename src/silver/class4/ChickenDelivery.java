package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDelivery {
    private static int m;
    private static final List<int[]> houses = new ArrayList<>();
    private static final List<int[]> stores = new ArrayList<>();
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (board[i][j] == 2) {
                    stores.add(new int[]{i, j});
                }
            }
        }

        selectChicken(0, 0, new int[m]);

        System.out.println(result);
        br.close();
    }

    private static void selectChicken(int start, int depth, int[] combination) {
        if (depth == m) {
            result = Math.min(result, getStoreDistance(combination));
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            combination[depth] = i;
            selectChicken(i + 1, depth + 1, combination);
        }
    }

    private static int getStoreDistance(int[] selected) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;

            for (int idx : selected) {
                int[] store = stores.get(idx); // cmd + option + v
                int distance = Math.abs(house[0] - store[0]) + Math.abs(house[1] - store[1]);
                minDistance = Math.min(minDistance, distance);
            }

            totalDistance += minDistance;
        }

        return totalDistance;
    }
}
