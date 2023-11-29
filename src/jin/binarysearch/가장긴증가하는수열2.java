package jin.binarysearch;

import java.io.*;
import java.util.*;

// [G2] 12015. 가장 긴 증가하는 부분 수열 2
public class 가장긴증가하는수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int A = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);

        for (int i = 1; i < A; i++) {
            if (result.get(result.size()-1) < arr[i]) {
                result.add(arr[i]);
            } else {
//                int idx = Collections.binarySearch(result, arr[i]);
                int idx = binarySearch(result, arr[i]);
                result.set(idx, arr[i]);
            }
        }
//        System.out.println("result = " + result);
        System.out.println(result.size());
    }

    private static int binarySearch(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;

            if (list.get(mid) == target) return mid;
            else if (list.get(mid) > target) l = mid + 1;
            else r = mid - 1;
            System.out.println("mid = " + mid);
        }

        return -1;
    }
}
