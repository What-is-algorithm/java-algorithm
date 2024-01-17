package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Todo N과 M (1) : "1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열"
// Todo N과 M (2) : + "오름차순" (
// Todo N과 M (3) : + "같은 수를 여러 번 고를 수 있음"
// Todo N과 M (4) : + "고른 수가 비내림차순" (ex. 1 1/1 2/1 3/1 4/ -> 다음에 2 1이 아닌 2 3/ ..)

// Todo N과 M (2) <-> 중복으로 고르지 않기 위해 사용한 visited 변수는 필요가 없음
// Todo 비내림차순 : 오름차순은 중복이 있을 수도 있는 반면, 비내림차순은 중복을 포함
public class NAndM4 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m]; // m개를 골라야 하므로

        dfs(0, 1);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i ++) {
                arr[depth] = i;

                dfs(depth + 1, i);
            }
        }
    }
