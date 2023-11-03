package yelim.graph;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 인접 행렬
// 2차원 배열로 연결 관계를 표현한다.
// 모든 관계에 대해 저장하여 메모리 낭비가 있을 수 있으나
// 배열에서 인덱스로 연결 정보를 접근할 경우, O(1)이다.
public class Virus {
    static int com;
    static int link;
    static int[][] arr;
    static boolean[] check;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컴퓨터 수
        com = Integer.parseInt(br.readLine());
        // 연결된 컴퓨터 쌍의 수
        link = Integer.parseInt(br.readLine());

        // 인접 행렬
        arr = new int[com+1][com+1];
        // 방문 여부
        check = new boolean[com + 1];
        // 바이러스에 걸린 컴퓨터 수
        cnt = 0;

        // 컴퓨터 연결 여부 저장
        for(int i=0;i < link;i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            // 컴퓨터가 연결만 되어 있다면 바이러스에 걸리므로
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);
        // 바이러스에 걸린 컴퓨터 수에서 시작 컴퓨터는 빼준다.
        System.out.println(cnt - 1);
    }

    static void dfs(int start) {
        // 탐색을 시작한 컴퓨터는 방문했다고 처리
        check[start] = true;
        // 바이러스에 걸린 컴퓨터 수 증가
        cnt++;

        for(int i=0;i < arr[start].length;i++) {
            if(!check[i] && arr[start][i] == 1) {
                dfs(i);
            }
        }
    }
}

