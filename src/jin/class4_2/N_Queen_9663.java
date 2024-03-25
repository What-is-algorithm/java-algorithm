package jin.class4_2;

import java.util.*;

public class N_Queen_9663 {

    static int N;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        boolean[] cols = new boolean[N];
        boolean[] diag = new boolean[2 * N];
        boolean[] revDiag = new boolean[2 * N];

        backtracking(0, cols, diag, revDiag);
        System.out.println(result);
    }

    private static void backtracking(int row, boolean[] cols, boolean[] diag, boolean[] revDiag) {
        if (row == N) result++;

        // 행, 열, 우상향 대각선, 우하향 대각선 x
        for (int col = 0; col < N; col++) {
            int idx1 = col + row;
            int idx2 = col + N - row;

            if (cols[col] || diag[idx1] || revDiag[idx2]) continue;

            cols[col] = true; diag[idx1] = true; revDiag[idx2] = true;
            backtracking(row + 1, cols, diag, revDiag);
            cols[col] = false; diag[idx1] = false; revDiag[idx2] = false;
        }
    }
}
