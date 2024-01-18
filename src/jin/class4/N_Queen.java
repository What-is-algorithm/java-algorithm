package jin.class4;

import java.io.*;

// [G4] 9663. N-Queen
// 행, 열, 우하향 대각선, 우상향 대각선 중복 x
public class N_Queen {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        boolean[] cols = new boolean[N];
        boolean[] diag = new boolean[2 * N];
        boolean[] revDiag = new boolean[2 * N];

        backtracking(0, cols, diag, revDiag, N);

        System.out.println(result);
        br.close();
    }

    private static void backtracking(int row, boolean[] cols, boolean[] diag, boolean[] revDiag, int n) {
        if (row == n) result++;

        for (int col = 0; col < n; col++) {
            int idx1 = col - row + n;
            int idx2 = col + row;

            if (cols[col] || diag[idx1] || revDiag[idx2]) continue;

            cols[col] = true; diag[idx1] = true; revDiag[idx2] = true;
            backtracking(row + 1, cols, diag, revDiag, n);
            cols[col] = false; diag[idx1] = false; revDiag[idx2] = false;
        }
    }
}
