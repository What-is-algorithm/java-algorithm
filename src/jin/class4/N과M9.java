package jin.class4;

import java.io.*;
import java.util.*;

// [S2] 15663. N과 M(9)

public class N과M9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        comb(0, new int[M], arr, visited);
        br.close();
    }

    private static void comb(int depth, int[] selected, int[] arr, boolean[] visited) {
        if (depth == selected.length) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                prev = arr[i];
                comb(depth + 1, selected, arr, visited);
                visited[i] = false;
            }
        }
    }
}
