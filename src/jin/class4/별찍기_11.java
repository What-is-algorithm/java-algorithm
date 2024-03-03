package jin.class4;

// [G4] 2448. 별 찍기 - 11

import java.util.Scanner;

public class 별찍기_11 {
    static char[][] DB = {
            "  *  ".toCharArray(),
            " * * ".toCharArray(),
            "*****".toCharArray()
    };

    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new char[N][2 * N - 1];

        solve(N / 3, 0, 0);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                result.append(map[i][j] == '*' ? '*' : ' ');
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
                System.arraycopy(DB[i], 0, map[y + i], x, 5);
            }
            return;
        }

        solve(n / 2, y, x + 3 * n / 2);
        solve(n / 2, y + 3 * n / 2, x);
        solve(n / 2, y + 3 * n / 2, x + 3 * n);
    }
}
