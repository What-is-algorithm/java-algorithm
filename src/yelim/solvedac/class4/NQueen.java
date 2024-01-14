package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    static int[] arr;
    static int N;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N]; // arr의 크기를 행으로 arr의 인덱스를 열로

        nQueen(0);
        System.out.println(result);
        br.close();
    }
    // 백트래킹의 재귀함수
    // if 출력/저장/정답이라면 -> 반환
    // else 출력/저장/정답이 아니라면
    //      for 모든 자식 노드에 대해
    //          if(출력/저장/정답의 가능성이 있다면) -> 자식 노드로 이동, 재귀함수(+1), 부모 노드로 이동
    static void nQueen(int num) { // num 번째 퀸을 넣어 탐색
        if(num == N) { // 퀸을 N개까지 놓았다면 가지 수를 세어준다.
            result++;
            return;
        }

        for(int i=0;i < N;i++) { // num번째 행, i번째 열에 퀸을 두었을 때
            arr[num] = i;
            if(possible(num)) { // 퀸이 있을 수 있다면(정답에 유망하다면)
                nQueen(num + 1); // 다음 퀸을 놓을 수 있는 탐색 시작
            }
        }
    }

    static boolean possible(int col) {
        for(int j=0;j < col;j++) { // 같은 열어 있거나 대각선에 있다면 false
            if(arr[j] == arr[col] || Math.abs(col - j) == Math.abs(arr[col] - arr[j])) {
                return false;
            }
        }
        return true;
    }
}
