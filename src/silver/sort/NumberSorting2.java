package silver.sort;

import java.io.*;
import java.util.Arrays;


// ※ 시간 제한 : 2s, 메모리 제한 : 256MB
// ※ O(1,000,000) -> O(nlogn)
// 물론, 정렬에도 O(nlogn)이 걸리지만, 중첩되는 과정은 아니므로 총 시간 복잡도는 O(nlogn)
public class NumberSorting2 {
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

        for (int i : arr) {
            sb.append(i).append('\n');
        }

        // 4. 출력
        System.out.println(sb);
        br.close();
    }
}
