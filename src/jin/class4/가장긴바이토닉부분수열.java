package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 11054. 가장 긴 바이토닉 부분 수열
public class 가장긴바이토닉부분수열 {
    // 가장 긴 증가하는 부분 수열 + 가장 긴 감소하는 부분 수열 만들기?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] lis = new int[N];
        int[] lds = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(data));

        // LIS
        lis[0] = 1;
        for (int i = 1; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(lis));

        // LDS
        lds[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = N - 1; j >= i; j--) {
                if (data[i] > data[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(lds));

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, lis[i] + lds[i] - 1);
        }

        System.out.println(result);
        br.close();
    }
}
