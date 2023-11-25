package yelim.binarysearch;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://steady-coding.tistory.com/20
// 임의의 수가 있는 행 이전에 있는 임의의 수 이하인 수들
// + 임의의 수가 있는 행에서 임의의 수 이하인 수들
// + 임의의 수가 있는 행 이후에 임의의 수 이하인 수들
// = 임의의 수는 몇 번째인지

// 임의의 수 mid, i번째 행
// 임의의 수 mid가 4일 때,
// 1번째 행 : min(4 / 1, 3) = 3
// 2번째 행 : min(4 / 2, 3) = 2
// 3번째 행 : min(4 / 3, 3) = 1
// -> 4 이하 수 개수 = 6개 < 7번째 수
// 임의의 수 4는 6번째 수이므로 7번째 수는 4보다 더 큰 수이다. -> l = mid + 1
// 임의의 수 mid가 6일 때,
// 1번째 행 : min(6 / 1, 3) = 3
// 2번째 행 : min(6 / 2, 3) = 3
// 3번째 행 : min(6 / 3, 3) = 2
// -> 6 이하 수 개수 = 8개 > 7번째 수
// 임의의 수 6은 8번째 수이므로 7번째 수는 6보다 더 작거나 같은 수이다. -> r = mid - 1, num = 6
// 임의의 수 mid가 5일 때,
// 1번째 행 : min(5 / 1, 3) = 3
// 2번째 행 : min(5 / 2, 3) = 2
// 3번째 행 : min(5 / 3, 3) = 1
// -> 5 이하 수 개수 = 6개 < 7번째 수
// 임의의 수 5는 6번째 수이므로 7번째 수는 5보다 더 큰 수이다. -> l = mid + 1
// (l = 6) >= (r = 5) -> 반복 탈출

public class Knumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A 배열의 크기 - 2차원 NxN (인덱스가 1부터 시작)
        int N = Integer.parseInt(br.readLine());
        // B 배열의 크기 - 1 ~ NxN (인덱스가 1부터 시작)
        // B 배열 오름차순 정렬했을 때, K번째 수
        int K = Integer.parseInt(br.readLine());

        long l = 1;
        long r = K;
        // K번째 수
        long num = 0;

        while(l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;

            for(int i=1;i <= N;i++) {
                cnt += Math.min(mid / i, N);
            }

            // mid는 "cnt번째 수 < K" 이므로 K는 mid보다 큰 수이다.
            if(cnt < K) {
                l = mid + 1;
            }
            // mid는 "cnt번째 수 >= K" 이므로 K는 mid보다 작거나 mid는 K번째 수가 맞다.
            else if(cnt >= K) {
                num = mid;
                r = mid - 1;
            }
        }

        System.out.println(num);
    }
}
