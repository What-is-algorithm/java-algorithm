package jin.class4_2;

import java.util.Scanner;

public class 별찍기_2448 {
    static char[][] DATA = {
            "  *  ".toCharArray(),
            " * * ".toCharArray(),
            "*****".toCharArray()
    };

    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        board = new char[N][2 * N - 1];

        solve(N / 3, 0, 0);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                result.append(board[i][j] == '*' ? '*' : ' ');
            }
            result.append("\n");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
        sc.close();
    }

    private static void solve (int n, int y, int x) {
        if (n == 1) {
            for (int i = 0; i < 3; i++) {
                System.arraycopy(DATA[i], 0, board[y + i], x, 5);
            }
            return;
        }

        solve(n / 2, y, x + 3 * n / 2);
        solve(n / 2, y + 3 * n / 2, x);
        solve(n / 2, y + 3 * n / 2, x + 3 * n);
    }
}
