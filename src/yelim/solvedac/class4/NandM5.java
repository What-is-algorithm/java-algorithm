package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NandM5 {
    static int N;
    static int M;
    static int[] arr;
    static int[] seq;
    static boolean[] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        String[] input = br.readLine().split(" ");
        arr = new int[N];
        for(int i=0;i < N;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        seq = new int[M];
        check = new boolean[N];
        sb = new StringBuilder();

        nAndM(0);

        System.out.println(sb);
        br.close();
    }

    // 백트래킹 -> 한 줄에 출력한 M개가 seq에 채워지면 출력
    //          모든 숫자에 대해 확인하지 않은 숫자라면
    //              -> 숫자를 확인하고 다음 탐색(출력될 수의 개수 + 1) -> 다시 돌아옴(숫자 확인 안한 상태로 다시 설정)
    static void nAndM(int depth) {
        if(depth == M) {
            for(int v : seq) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i < N;i++) {
            if(!check[i]) {
                check[i] = true;
                seq[depth] = arr[i];
                nAndM(depth + 1);
                check[i] = false;
            }
        }
    }
}
