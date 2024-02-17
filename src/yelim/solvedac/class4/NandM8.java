package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NandM8 {
    static int N;
    static int M;
    static int[] arr;
    static int[] seq;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i < N;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        seq = new int[M];
        sb = new StringBuilder();

        nAndM(0, 0);

        System.out.println(sb);
        br.close();
    }

    // 중복을 허용하지만 오름차순으로 뽑기
    static void nAndM(int idx, int depth) {
        if(depth == M) {
            for(int v : seq) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx;i < N;i++) {
            seq[depth] = arr[i];
            nAndM(i, depth + 1);
        }
    }
}
