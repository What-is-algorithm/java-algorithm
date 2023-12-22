package jin.sort;

import java.io.*;
import java.util.Arrays;

// [S5] 2751. 수 정렬하기 2
public class 수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int n : arr) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
