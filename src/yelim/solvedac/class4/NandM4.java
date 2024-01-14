package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM4 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        arr = new int[m];

        nAndM(1, 0);
        System.out.println(sb);
        br.close();
    }

    static void nAndM(int start, int num) {
        if(num == m) { // m개까지 출력할 수 있다면 종료
            for(int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i <= n;i++) {
            arr[num] = i; // start 이후 수를 배열에 넣으면서
            nAndM(i, num + 1); // 다음 수를 배열에 넣기 위한 재귀 함수
        }
        // nandm(1, 0) -> for(i = 1 -> [1 ] -> nandm(1, 1) 끝 -> i = 2 -> [2 ] -> nandm(2, 1) 끝 -> i = 3 -> [3 ] -> nandm(3, 1) 끝 -> i = 4 -> [4 ] -> nandm(4, 1) 끝)
        //      -> nandm(1, 1) -> for(i = 1 -> [1 1] -> nandm(1, 2) 끝 -> i = 2 -> [1 2] -> nandm(2, 2) 끝 -> i = 3 -> [1 3] -> nandm(3, 2) 끝 -> i = 4 -> [1 4] -> nandm(4, 2) 끝)
        //          -> nandm(1, 2) -> if(2 == 2 -> "1 1" 출력)
        //          -> nandm(2, 2) -> if(2 == 2 -> "1 2" 출력)
        //          -> nandm(3, 2) -> if(2 == 2 -> "1 3" 출력)
        //          -> nandm(4, 2) -> if(2 == 2 -> "1 4" 출력)
        //      -> nandm(2, 1) -> for(i = 2 -> [2 2] -> nandm(2, 2) 끝 -> i = 3 -> [2 3] -> nandm(3, 2) 끝 -> i = 4 -> [2 4] -> nandm(4, 2) 끝)
        //          -> nandm(2, 2) -> if(2 == 2 -> "2 2" 출력)
        //          -> nandm(3, 2) -> if(2 == 2 -> "2 3" 출력)
        //          -> nandm(4, 2) -> if(2 == 2 -> "2 4" 출력)
        //      -> nandm(3, 1) -> for(i = 3 -> [3 3] -> nandm(3, 2) 끝 -> i = 4 -> [3 4] -> nandm(4, 2) 끝)
        //          -> nandm(3, 2) -> if(2 == 2 -> "3 3" 출력)
        //          -> nandm(4, 2) -> if(2 == 2 -> "3 4" 출력)
        //      -> nandm(4 ,1) -> for(i = 4 -> [4 4] -> nandm(4, 2) 끝)
        //          -> nandm(4, 2) -> if(2 == 2 -> "4 4" 출력)
    }
}
