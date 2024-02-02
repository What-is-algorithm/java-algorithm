package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Todo 트리 구조의 특징 : 루트 노드에서부터 탐색을 시작하면 특정 노드의 부모 노드를 알 수 있음
// Todo 재귀를 사용
// Todo DFS
public class FindParentOfTree {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // ..
        }
    }
}
