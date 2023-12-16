package jin.sort;

import java.io.*;

// [B1] 10989. 수 정렬하기 3
public class 수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx] += 1;
        }

        // O(N)
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
