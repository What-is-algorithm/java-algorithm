package jin.class4;

import java.io.*;
import java.util.*;

// [S3] 15652. N과 M (4)
public class N과M4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[] data = new int[M];

        backtrack(data, N, M, 1, 0);

        br.close();
    }

    private static void backtrack(int[] data, final int n, final int m, int start, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : data) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= n; i++) {
            data[depth] = i;
            backtrack(data, n, m, i, depth + 1);
        }
    }
}