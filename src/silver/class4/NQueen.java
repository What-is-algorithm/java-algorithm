package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    private static int[] arr;
    private static int n;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (possible(depth))
                dfs(depth + 1);
        }
    }

    private static boolean possible(int column) {
        for (int i = 0; i < column; i++) {
            if (arr[i] == arr[column]) {
                return false;
            } else if (Math.abs(column - i) == Math.abs(arr[column] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
