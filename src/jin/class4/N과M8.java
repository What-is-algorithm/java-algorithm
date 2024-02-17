package jin.class4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// [S3] 15657. N과 M(8)
public class N과M8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtracking(arr, new int[M], 0, 0);
        br.close();
    }

    private static void backtracking(int[] arr, int[] selected, int start, int depth) {
        if (depth == selected.length) {
            StringBuilder sb = new StringBuilder();
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            selected[depth] = arr[i];
            backtracking(arr, selected, i, depth + 1);
        }
    }
}
