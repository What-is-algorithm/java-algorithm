# 9663 NQueen

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int result = 0;
    private static int[] table; // idx: row, element: col
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new int[N];
        scan(0);

        System.out.println(result);
    }
    private static void scan(int depth) {
        if (depth == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            table[depth] = i;
            if (isPossible(depth)) {
                scan(depth + 1);
            }
        }
    }

    private static boolean isPossible(int y) {
        for (int i = 0; i < y; i++) {
            if (table[y] == table[i]) {
                return false;
            } else if (Math.abs(y - i) == Math.abs(table[y] - table[i])) {
                return false;
            }
        }
        return true;
    }
//    private static void scan(int y, int N) {
//        if (y == N) {
//            result++;
//            return;
//        }
//
//        for (int x = 0; x < N; x++) {
//            int col = x;
//            int diagonal = y - x;
//            int antiDiagonal = y + x;
//            if (cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
//                continue;
//            }
//            cols.add(col);
//            diagonals.add(diagonal);
//            antiDiagonals.add(antiDiagonal);
//            scan(y + 1, N);
//            cols.remove(col);
//            diagonals.remove(diagonal);
//            antiDiagonals.remove(antiDiagonal);
//        }
//
//    }
}
```

