package silver.sort;

import java.io.*;
import java.util.Arrays;

// ※ 시간 제한 : 3s, 메모리 제한 : 512MB
// ※ O(10,000,000) -> O(n)
public class NumberSorting3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입출력
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 2. 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 3. 로직
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append('\n');
        }

        // 4. 출력
        System.out.println(sb);
        br.close();
    }
}