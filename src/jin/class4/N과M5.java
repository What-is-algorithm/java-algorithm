package jin.class4;

import java.io.*;
import java.util.*;

// [S3]. 15654 N과 M (5)
public class N과M5 {
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

        backtracking(arr, new int[M], visited, 0);
        br.close();
    }

    private static void backtracking(int[] arr, int[] temp, boolean[] visited, int depth) {
        if (depth == temp.length) {
            StringBuilder sb = new StringBuilder();
            for(int n : temp) {
                sb.append(n).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                temp[depth] = arr[i];
                visited[i] = true;
                backtracking(arr, temp, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
