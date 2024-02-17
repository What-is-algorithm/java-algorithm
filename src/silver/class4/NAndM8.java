package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO 순열 : 서로 다른 n개 중 r개를 뽑아서 나열 <-> 조합 : 서로 다른 n개 중 r개를 순서 없이 나열

// TODO "N"개의 자연수 중에서 M개를 고른 순열 + 같은 수를 여러 번 골라도 된다. -> 중복 순열 또는 중복 조합
// TODO 고른 수열은 비내림차순이어야 한다. -> 다음 항이 같거나 큰 비내림차순
// TODO 중복되는 수열을 여러 번 출력하면 안됨 -> (1, 7) = (7, 1) -> 중복 조합
// TODO 한 줄에 하나씩 + 한 줄에는 공백으로 구분 -> sb.append().append("\n")
// TODO 사전 순으로 출력 -> Arrays.sort()
public class NAndM8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] tempArr = new int[m];

        duplicateCombination(0, 0, n, m, arr, tempArr);
        br.close();
    }

    private static void duplicateCombination(int start, int depth, int n, int m, int[] arr, int[] tempArr) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();

            for (int result : tempArr) {
                sb.append(result + " ");
            }

            System.out.println(sb);
            return;
        }

        for (int i = start; i < n; i++) {
            tempArr[depth] = arr[i];

            duplicateCombination(i, depth + 1, n, m, arr, tempArr);
        }
    }
}
