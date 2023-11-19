package yelim.binarysearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Installwifi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nc = br.readLine().split(" ");
        // 집의 수
        int n = Integer.parseInt(nc[0]);
        // 공유기의 수
        int c = Integer.parseInt(nc[1]);

        // 집의 좌표
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 가능한 최소 간격
        int l = 1;
        // 입력 받은 집들의 최대 간격
        int r = arr[n - 1];

        while (l <= r) {
            // 최소 간격
            int mid = (l + r) / 2;

            // 공유기 설치 위치(처음부터 시작)
            int position = 0;
            // 설치 가능한 공유기 수
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                // 공유기 설치 위치와의 간격이 최소 간격보다 크거나 같다면 설치한다.
                if (arr[i] - arr[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

            // 설치된 공유기 수가 가지고 있는 공유기의 수보다 적으면
            // 최소 거리 줄인다.
            if (cnt < c) {
                r = mid - 1;
                continue;
            }
            //설치된 공유기 수가 가지고 있는 공유기 수보다 크다면
            // 최소 거리 늘린다.
            else if(cnt >= c) {
                l = mid + 1;
            }

        }

        // 설치한 수 == 가지고 있는 수가 되었을 때 while문을 끝내지 않고
        // 설치한 수 < 가지고 있는 수가 될 때가 되었을 때 끝냈기 때문에
        // 최소 거리의 최대(조건을 부합하지 않기 직전) 값을 출력하기 위해 1을 빼준다.
        System.out.println(l - 1);
    }
}
