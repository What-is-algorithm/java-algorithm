package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO n개의 자연수 중에서 m개를 고른 수열 구하기
// TODO 한 줄에 하나씩 수열을 출력
// TODO - 중복되는 수열은 제외
// TODO - 각 수열은 공백으로 구분
// TODO - 오름차순 (= Arrays.sort())

// TODO 순열 : 서로 다른 n개 중 r개를 뽑아서 나열한 것 <-> 조합 : 서로 다른 n개 중 r개를 순서 없이 골라낸 것
// TODO 이 문제는 순열을 구하라고 하였으므로 (1, 2)와 (2, 1)은 다름
public class NAndM5 {
    private static boolean[] visited; // 순열 - 중복을 제거하기 위한 방문 처리
    private static int[] tempArray;// 오름차순으로 출력해야하니까, 저장용 배열이 필요할 것 같은데?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        // 1. 입력 받기
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        // 2. 순열
        // TODO visited : numbers 배열의 인덱스를 방문했나 안했나
        visited = new boolean[n];
        tempArray = new int[m];

        permutation(n, m, 0, numbers);

        br.close();
    }

    private static void permutation(int n, int m, int depth, int[] numbers) {
        // 이걸 왜 백트래킹으로 풀 생각을 했을까?
        // 흠.. 일단 재귀의 형태로 풀게 될테니까 트리 구조로 생각을 한 번 해보자. 공책에 그려야징

        // 1. 탈출 조건
        // 재귀의 형태니까 탈출한다고 해도 재귀가 하나 벗겨지는 느낌인데.. 뭐가 m이랑 같아야 탈출을 할까?
        // 트리를 기준으로 dfs는 한 단계, 한 단계씩 들어가는 느낌이므로 depth 변수를 통해 높이를 측정
        if (depth == m) {
            StringBuilder sb = new StringBuilder();

            for (int tmp : tempArray) {
                sb.append(tmp).append(" ");
            }

            System.out.println(sb);
            return;
        }

        // 2. 백트래킹
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // TODO (예제 입력 2 기준) 1을 탐색하기 위해 위 for문을 수행 (i = 0)
                // TODO 그리고 오름차순이므로 다음 원소인 7을 탐색하기 위해 permutation()을 한 번 더 호출함으로써 내부의 for문을 수행 (i = 0)
                // TODO 즉, for문이 쌓였으므로 2중 for문 형태
                // TODO (depth = 0, 첫 번째 for문) 그리고 첫 번째 for문에 따른 tempArray[0]은 1로 픽스된 채, (depth = 1, 두 번째 for문)에 따라 (i = 0일 경우는 1이므로 true처리가 되어 있음에 따라 넘어가고, i = 1일 경우) tempArray[1] = 7
                // TODO 이후, depth == m == 2가 됨에 따라 해당 메서드는 탈출하고 되고, 7에 대한 인덱스 방문 처리는 false
                // TODO 다음 두 번째 for문의 i가 1가 되면서 tempArray[1] =7에서 8로 덮여씌여지게 되고, ..
                // TODO 이후 첫 번째 for문이 완전히 끝나면, depth = 1이었던 원소 1도 false처리가 됨
                // TODO 그라고 첫 번째 for문의 i가 1이 되면서, 원소 7을 기준으로 백트래킹 시작 ..
                tempArray[depth] = numbers[i];

                permutation(n, m, depth + 1, numbers);

                visited[i] = false;
            }
        }
    }
}
