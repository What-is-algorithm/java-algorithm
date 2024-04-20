package jin.class4_2;

import java.io.*;
import java.util.*;

public class 숨바꼭질3_13549 {

    static int N, K;
    static int[] data;
    static int MAX_NUM = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();
        data = new int[2 * MAX_NUM + 1];
        Arrays.fill(data, MAX_NUM);
        data[N] = 0;
        if (N >= K) {
            System.out.println(N - K);
            return;
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        pq.add(new int[]{N, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == K) {
                return data[K];
            }

            if (data[curr[0]] < curr[1]) continue;

            int minus = curr[0] - 1;
            int plus = curr[0] + 1;
            int multiple = curr[0] * 2;

            if (minus >= 0 && data[minus] > curr[1] + 1) {
                data[minus] = curr[1] + 1;
                pq.add(new int[]{minus, data[minus]});
            }

            if (plus <= K && data[plus] > curr[1] + 1) {
                data[plus] = curr[1] + 1;
                pq.add(new int[]{plus, data[plus]});
            }

            if (multiple <= K && data[multiple] > curr[1]) {
                data[multiple] = curr[1];
                pq.add(new int[]{multiple, data[multiple]});
            }
        }

        return -1;
    }
}
