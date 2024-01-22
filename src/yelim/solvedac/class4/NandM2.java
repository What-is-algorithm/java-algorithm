package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백트래킹 - 불필요한 부분을 없애고 최대한 올바른 쪽으로 가는 방식
//      > 모든 경우의 수 중에서 특정 조건을 만족하는 경우만 보는 것
//      > 더 이상 탐색할 필요가 없는 상태를 제외하는 것
public class NandM2 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열(오름차순)

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        arr = new int[m]; // m개를 출력하기 위한 배열

        nAndM(1, 0);
        System.out.println(sb);
        br.close();
    }

    // 백트래킹의 재귀함수
    // if 출력/저장/정답이라면 -> 반환
    // else 출력/저장/정답이 아니라면
    //      for 모든 자식 노드에 대해
    //          if(출력/저장/정답의 가능성이 있다면) -> 자식 노드로 이동, 재귀함수(+1), 부모 노드로 이동
    static void nAndM(int start, int num) {
        // m개 까지 출력을 할 수 있다면 종료
        if(num == m) {
            for(int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i <= n;i++) {
            arr[num] = i; // start 이후 수를 배열에 넣으면서
            nAndM(i + 1, num + 1); // 다음 수를 배열에 넣기 위한 재귀 함수

        }
        // nandm(1, 0) -> for(i = 1 -> [1 ] -> nandm(2, 1) 끝 -> i = 2 -> [2 ] -> nandm(3, 1) 끝 -> i = 3 -> [3 ] -> nandm(4, 1) 끝 -> i = 4 -> [4 ] -> nandm(5, 1) 끝)
        //      -> nandm(2, 1) -> for(i = 2 -> [1 2] -> nandm(3, 2) 끝 -> i = 3 -> [1 3] -> nandm(4, 2) 끝 -> i = 4 -> [1 4] -> nandm(5, 2) 끝)
        //          -> nandm(3, 2) -> if(2 == 2 -> "1 2" 출력)
        //          -> nandm(4, 2) -> if(2 == 2 -> "1 3" 출력)
        //          -> nandm(5, 2) -> if(2 == 2 -> "1 4" 출력)
        //      -> nandm(3, 1) -> for(i = 3 -> [2 3] -> nandm(4, 2) 끝 -> i = 4 -> [2 4] -> nandm(5, 2) 끝)
        //          -> nandm(3, 2) -> if(2 == 2 -> "2 3" 출력)
        //          -> nandm(5, 2) -> if(2 == 2 -> "2 4" 출력)
        //      -> nandm(4, 1) -> for(i = 4 -> [3 4] -> nandm(5, 2) 끝)
        //          -> nandm(5, 2) -> if(2 == 2 -> "3 4" 출력)
        //      -> nandm(5, 1) -> for(i = 5 -> 5 >= 4 -> 끝)
    }
}
