package jin.stackquedeque;

import java.io.*;
import java.util.*;
// [S3] 2346. 풍선 터트리기
// idx % size ??? X
// Deque<int[]> -> int[]{idx, moveDistance}
// idx > 0 -> (배열로 생각할 떄) 좌측에서 뺴서 우측에 넣기
// idx < 0 -> (배열로 생각할 떄) 우측에서 뺴서 좌측에 넣기
public class 풍선터트리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(" ");
        int idx = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        /*for(int[] a : deque) {
            System.out.println(Arrays.toString(a));
        }*/

        while (!deque.isEmpty()) {
            // idx > 0
            if (idx > 0) {
                for (int i = 1; i < idx; i++) {
                    deque.offerLast(deque.pollFirst());
                }

                int[] next = deque.removeFirst();
                idx = next[1];
                sb.append(next[0]).append(" ");
                continue;
            }

            // idx < 0
            if (idx < 0) {
                for (int i = idx; i < -1; i++) {
                    deque.offerFirst(deque.pollLast());
                }

                int[] next = deque.removeLast();
                idx = next[1];
                sb.append(next[0]).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
