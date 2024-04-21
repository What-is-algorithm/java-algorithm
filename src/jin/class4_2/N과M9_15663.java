package jin.class4_2;

import java.io.*;
import java.util.*;

public class N과M9_15663 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        Arrays.sort(arr);
        backtracking(new int[M], new boolean[N], 0);
    }

    private static void backtracking(int[] selected, boolean[] visited, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        int prev = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                prev = arr[i];
                backtracking(selected,  visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
