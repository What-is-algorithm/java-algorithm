package jin.class4_2;

import java.io.*;
import java.util.*;

public class 가장긴바이토닉부분수열_11054 {

    static int N;
    static int[] data;
    static int[] lis;
    static int[] lds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        lis = new int[N];
        lds = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }


        lis[0] = 1;
        for (int i = 1; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        lds[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (data[i] > data[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, lis[i] + lds[i] - 1);
        }
        System.out.println(result);
    }
}
