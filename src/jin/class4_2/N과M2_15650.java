package jin.class4_2;

// [S3] 15650. N과 M(2)

import java.io.*;
import java.util.StringTokenizer;

public class N과M2_15650 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtrack(new int[M], 0, 1);
    }

    private static void backtrack(int[] selected, int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            backtrack(selected, depth + 1, i + 1);
        }
    }
}
