package yelim.binarysearch;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cutcable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] kn = br.readLine().split(" ");
        // 랜선 수
        int K = Integer.parseInt(kn[0]);
        // 만들어야하는 같은 길이의 랜선 수
        int N = Integer.parseInt(kn[1]);

        // 만들 수 있는 최소 랜선 길이
        long l = 1;
        // 최대 랜선 길이
        long r = 0;

        // 케이블 길이 배열
        int[] cable = new int[K];
        for(int i=0;i < K;i++) {
            cable[i] = Integer.parseInt(br.readLine());
            // 최대 랜선 길이를 케이블 길이를 배열에 저장하면서 갱신
            r = Math.max(r, cable[i]);
        }

        long mid = 0;
        while(l <= r) {
            mid = (l + r) / 2;
            System.out.println(l + ", " + r + ", mid : " + mid);

            // 자른 랜선의 개수
            long sum = 0;
            for(int j=0;j < K;j++) {
                sum += cable[j] / mid;
            }

            // 자른 랜선의 개수와 만들어야 할 랜선의 개수 비교
            // 만들어야 할 랜선의 개수보다 적으므로
            // 기존 길이 범위에서 mid보다 작아야하기 때문에
            // 최대 랜선 길이를 짧게 해야 한다.
            if(N > sum) {
                r = mid - 1;
            }
            // 만들어야 할 랜선의 개수보다 크거나 같으므로
            // 기존 길이 범위에서 mid보다 커야하기 때문에
            // 최소 랜선 길이를 길게 해야 한다.

            // 만들어야 할 랜선 개수가 자른 랜선 개수와 같다면
            // 만들어야 할 랜선 개수 이상이 처음 나오는 길이를 중심으로
            // 만들어야 할 랜선 개수를 좁히도록 반복한다.
            // 1, 802, mid : 401
            // 1, 400, mid : 200
            // 201, 400, mid : 300
            // 201, 299, mid : 250
            // 201, 249, mid : 225
            // 201, 224, mid : 212
            // 201, 211, mid : 206
            // 201, 205, mid : 203
            // 201, 202, mid : 201
            else if(N <= sum) {
                l = mid + 1;
            }
        }

        System.out.println((l + r) / 2);
    }
}
