package jin.class4_2;

import java.io.*;
import java.util.*;

public class N과M8_15657 {

    static int N, M;
    static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(data);
        backtracking(new int[M], 0, 0);
    }

    private static void backtracking(int[] selected, int start, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        for (int i = start; i < N; i++) {
            selected[depth] = data[i];
            backtracking(selected, i, depth + 1);
        }
    }
}
