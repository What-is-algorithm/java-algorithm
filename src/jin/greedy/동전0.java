package jin.greedy;

import java.io.*;
import java.util.*;

// [S4] 11047. 동전 0
// 화폐 내림차순
// coin += money / 화폐
// money = money % 화폐
public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int coin = 0;
        int money = K;

        for (int i = arr.length-1; i >= 0; i--) {
            coin += money / arr[i];
            money %= arr[i];
        }

        System.out.println(coin);
    }
}
