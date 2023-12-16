package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S4] 28279. 덱2
public class 덱2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        final int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int ca = input[0];
            switch (ca) {
                case 1:
                    deque.offerLast(input[1]);
                    break;
                case 2:
                    deque.offerFirst(input[1]);
                    break;
                case 3:
                    sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
                    break;
                case 4:
                    sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
                case 8:
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                default:
                    throw new IllegalArgumentException("존재하지 않는 명령어입니다.");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
