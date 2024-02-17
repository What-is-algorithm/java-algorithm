package jin.class4;

import java.io.*;
import java.util.*;

// [G5] 13549. 숨바꼭질 3
public class 숨바꼭질3 {
    static class Node implements Comparable<Node>{
        int pos, time;

        public Node (int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.time, other.time);
        }
    }

    static final int MAX_NUM = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] times = new int[2 * MAX_NUM + 1];
        Arrays.fill(times, MAX_NUM);

        int result;

        if (N >= K) {
            result = N - K;
        } else {
            result = bfs(times, N, K);
        }
        System.out.println(result);
    }

    private static int bfs(int[] times, int N, int K) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));
        times[N] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.pos == K) {
                return times[K];
            }

            if (times[curr.pos] < curr.time) continue;

            int minusPos = curr.pos - 1;
            int plusPos = curr.pos + 1;
            int multiplePos = curr.pos * 2;

            if (minusPos >= 0 && times[minusPos] > curr.time + 1) {
                times[minusPos] = curr.time + 1;
                pq.add(new Node(minusPos, times[minusPos]));
            }

            if (plusPos <= MAX_NUM && times[plusPos] > curr.time + 1) {
                times[plusPos] = curr.time + 1;
                pq.add(new Node(plusPos, times[plusPos]));
            }

            if (multiplePos <= 2 * MAX_NUM && times[multiplePos] > curr.time) {
                times[multiplePos] = curr.time;
                pq.add(new Node(multiplePos, times[multiplePos]));
            }
        }

        return -1;
    }
}
