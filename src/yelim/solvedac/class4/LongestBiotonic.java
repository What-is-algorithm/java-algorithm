package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestBiotonic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 바이오토닉 : 특정 값을 기준으로 왼쪽 부분은 오름차순, 오른쪽 부분은 내림차순
        // ex. {1, 5, 2, 1, 4, 3, 4, 5, 2, 1}
        // (왼 -> 오) : {1} -> 길이 1, {1, 5} -> 길이 2, {1, 2} -> 길이 2, {1} -> 길이 1, {1, 2, 4} -> 길이 3, {1, 2, 3} -> 길이 3, {1, 2, 3, 4} -> 길이 4, {1, 2, 3, 4, 5} -> 길이 5, {1, 2} -> 길이 2, {1} -> 길이 1
        //              => [1, 2, 2, 1, 3, 3, 4, 5, 2, 1]
        // (오 -> 왼) : {1} -> 길이 1, {1, 2} -> 길이 2, {1, 2, 5} -> 길이 3, {1, 2, 4} -> 길이 3, {1, 2, 3} -> 길이 3, {1, 2, 3, 4} -> 길이 4, {1} -> 길이 1, {1, 2} -> 길이 2, {1, 2, 3, 4, 5} -> 길이 5, {1} -> 길이 1
        //              => [1, 5, 2, 1, 4, 3, 4, 5, 2, 1]
        // 두 수열 합친 것 : {1} + {1} = {1} -> 길이 1, {1, 5} + {5, 4, 3, 2, 1} = {1, 5, 4, 3, 2, 1} -> 길이 6, {1, 2} + {2, 1} = {1, 2, 1} -> 길이 3, {1} + {1} = {1} -> 길이 1, {1, 2, 4} + {4, 3, 2, 1} = 길이 6,
        //                 {1, 2, 3} + {3, 2, 1} = {1, 2, 3, 2, 1} -> 길이 5, {1, 2, 3, 4} + {4, 2, 1} = {1, 2, 3, 4, 2, 1} -> 길이 6, {1, 2, 3, 4, 5} + {5, 2, 1} = {1, 2, 3, 4, 5, 2, 1} -> 길이 7,
        //                 {1, 2} + {2, 1} = {1, 2, 1} -> 길이 3, {1} + {1} = {1} -> 길이 1
        // (왼 -> 오)에서 오름차순한 것 + (오 -> 왼)에서 오름차순한 것 -> 합친 배열(원소 1개씩 중복되므로 원소 하나씩 빼주기)에서 최댓값이 답

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        String[] input = br.readLine().split(" ");
        for(int i=1;i <= N;i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        int[] dpLR = new int[N+1];
        // 왼쪽 -> 오른쪽
        for (int i = 1; i <= N; i++) {
            dpLR[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j])
                    dpLR[i] = Math.max(dpLR[i], dpLR[j] + 1);
            }
        }

        // 오른쪽 -> 왼쪽
        int[] dpRL = new int[N+1];
        for (int i = N; i >= 1; i--) {
            dpRL[i] = 1;
            for (int j = N; j >= 1; j--) {
                if (arr[i] > arr[j])
                    dpRL[i] = Math.max(dpRL[i], dpRL[j]+1);
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dpLR[i] + dpRL[i], max);
        }
        // 최댓값 중복 제거
        System.out.println(max - 1);
        br.close();

    }
}
// https://st-lab.tistory.com/136