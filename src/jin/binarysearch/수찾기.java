package jin.binarysearch;

import java.io.*;
import java.util.*;

// [S4] 1920. 수 찾기
public class 수찾기 {
    static int N;
    static int M;
    static int[] arrN;
    static int[] arrM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arrN);
        M = Integer.parseInt(br.readLine());
        arrM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int num : arrM) {
            System.out.println(binarySearch(arrN, num));
        }
        br.close();
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = N-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return 1;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return 0;
    }
}
