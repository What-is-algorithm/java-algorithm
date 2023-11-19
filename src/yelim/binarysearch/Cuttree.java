package yelim.binarysearch;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cuttree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        // 나무 수
        int N = Integer.parseInt(nm[0]);
        // 나무 길이
        int M = Integer.parseInt(nm[1]);

        long l = 0;
        long r = 0;

        // 나무 길이 배열
        int[] tree = new int[N];
        String[] tstr = br.readLine().split(" ");
        for(int i=0;i < N;i++) {
            tree[i] = Integer.parseInt(tstr[i]);
            r = Math.max(r, tree[i]);
        }

        while(l <= r) {
            long mid = (l + r) / 2;
            System.out.println(l + ", " + r + ", mid : " + mid);


            long sum = 0;
            for(int j=0;j < N;j++) {
                sum += (tree[j] > mid) ? tree[j] - mid : 0;
            }

            // 가져갈 나무 길이보다 짧으므로
            // 절단기의 높이를 낮춘다.
            if(M > sum) {
                r = mid - 1;
            }
            // 가져갈 나무 길이보다 길거나 같으면
            // 절단기의 높이를 높인다.
            // 0, 20, mid : 10
            // 11, 20, mid : 15
            // 16, 20, mid : 18
            // 16, 17, mid : 16
            // 15
            else if(M <= sum) {
                l = mid + 1;
            }
        }

        System.out.println((l + r) / 2);
    }
}
