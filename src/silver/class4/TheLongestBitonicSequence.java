package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLongestBitonicSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Todo 바이토닉 수열 : 수열 S가 어떤 수 S_k를 기준으로 작다가 커지는 수열
        // Todo ex. S_k = 30, {10 -> 20 -> 30 -> 25 -> 20}
        // Todo ex. S_k = 40, {10, 20, 30, 40} -> 애는 왜 바이토닉 수열이지..?
        // Todo ex. S_k = 50, {50, 40, 25, 10} -> 얘도 왜 바이토닉 수열이지..?
        // Todo 커지기만 하거나, 작아지기만 하는 수열도 바이토닉 수열인가?

        // Todo {1 -> 2 -> 3 -> 2 -> 1 - (다시 반복되어서 안되나?) -> 2 -> 3 -> 2 -> 1}
        // Todo {10 -> 20 -> 30 -> 40 - 20 - (아마 20이 30보다 작은데, 순서상 30 -> 20이 되어야 맞았을듯 or 이미 카운트 된 원소들이라 안되나?) -> 30}
        // Todo 결과적으로, 데이터가 증가했다가 감소한다면 가장 긴 수열의 길이라는 조건을 충족할 수 없음

        // Todo 1. LI(증가)S LD(감소)S를 같은 공간에 둘 수 있을까? -> 안된다, 왜냐하면 for문으로 순회할 경우 반드시 값이 커지거나 작아지거나 둘 중 하나이기 때문
        // Todo 1-1. 같은 공간에 둘 수 없다면 각각의 공간을 만들어야 할까? -> 흠..
        // Todo 2. LIS는 어떻게 가장 긴 증가하는 수열을 보장할까?
        // Todo 3. LDS는 어떻게 가장 긴 감소하는 수열을 보장할까?
        // Todo 4. 바이토닉 수열 : LIS + LDS를 어떻게 해야 합쳐서 바이토닉이 만들어질까?
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) {

        }

    }
}
