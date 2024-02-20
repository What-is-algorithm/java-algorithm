package jin.class4;

import java.io.*;
import java.util.*;

// [S2] 15666. N과 M (12)
public class N과M12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtracking(0, 0, new int[M], arr);
        br.close();
    }

    private static void backtracking(int start, int depth, int[] selected, int[] arr) {
        if (depth == selected.length) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        int prev = -1;
        for (int i = start; i < arr.length; i++) {
            if (prev != arr[i]) {
                selected[depth] = arr[i];
                prev = arr[i];
                backtracking(i, depth + 1, selected, arr);
            }
        }
    }
}
