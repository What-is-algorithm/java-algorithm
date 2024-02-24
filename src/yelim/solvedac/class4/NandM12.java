package yelim.solvedac.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;

public class NandM12 {
    static int N;
    static int M;
    static HashSet<String> output;
    static int[] arr;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 같은 수를 여러 번 골라도 된다.
        // 비내림차순
        // 출력되는 수열은 중복되면 안된다.
        String[] nm = br.readLine().split(" ");
        // 1 <= M <= N <= 8
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        // 입력 수 <= 10000
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i < input.length;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        seq = new int[M];
        output = new HashSet<>();

        nAndM(0, 0);

        // 앞에서 arr를 정렬한다고 해도 HashSet 자체는 정렬이 되지 않고 List로 바꾸어야 한다...
        // 다른 방법으로 TreeSet으로 변환하면 자동으로 정렬된다.
        List<String> forSort = new ArrayList<>(output);
        Collections.sort(forSort);

        StringBuilder sb = new StringBuilder();
        for(String str : forSort) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    // HashSet
    // add : O(1)
    // contains : O(1)
    static void nAndM(int start, int depth) {
        if(depth == M) {
            StringBuilder tmpSeq = new StringBuilder();
            for(int v : seq) {
                tmpSeq.append(v).append(" ");
            }
            output.add(tmpSeq.toString());
            return;
        }

        for(int i=start;i < arr.length;i++) {
            seq[depth] = arr[i];
            nAndM(i, depth + 1);
        }
    }
}
