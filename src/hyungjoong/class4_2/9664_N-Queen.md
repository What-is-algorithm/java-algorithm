# 9664 N-Queen

백트래킹을 통해 조건에 맞는 칸일 찾고 탐색 depth를 넓혀가며 경우의 수를 추적하면 됩니다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean isPossible(int depth, int[] col) {
        for (int i = 0; i < depth; i++) {
            if (col[i] == col[depth] || Math.abs(col[i] - col[depth]) == depth - i) { // 같은 열에 있거나 대각선에 위치한 경우
                return false;
            }
        }
        return true;
    }

    private static int backtracking(int depth, int N, int[] col) {
        if (depth == N) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            col[depth] = i;
            if (isPossible(depth, col)) {
                count += backtracking(depth + 1, N, col);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] col = new int[N];
        System.out.println(backtracking(0, N, col));
    }
}
```

