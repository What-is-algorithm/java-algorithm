package jin.class4_2;

import java.io.*;
import java.util.*;

public class N과M12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arr);

        backtracking(arr, 0, m, new ArrayList<>());
    }

    private static void backtracking(int[] arr, int start, int max, ArrayList<Integer> list) {
        if (list.size() == max) {
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        int prev = -1;
        for (int i = start; i < arr.length; i++) {
            if (prev != arr[i]) {
                prev = arr[i];
                list.add(arr[i]);
                backtracking(arr, i, max, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
