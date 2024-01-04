# 9663 NQueen

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int result = 0;
    private static int[] table; // idx: col, element: row
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new int[N];
        scan(0);

        System.out.println(result);
    }
    private static void scan(int y) {
        if (y == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            table[y] = i;
            if (isPossible(y)) {
                scan(y + 1);
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
}
```

