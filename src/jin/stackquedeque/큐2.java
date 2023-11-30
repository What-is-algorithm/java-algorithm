package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S4] 18258. 큐 2
public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> que = new ArrayDeque<>();
        final int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            switch (command) {
                case "push":
                    que.addFirst(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    sb.append(remove(que)).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    sb.append(getIsEmpty(que.isEmpty())).append("\n");
                    break;
                case "front":
                    sb.append(getFrontNum(que)).append("\n");
                    break;
                case "back":
                    sb.append(getBackNum(que)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static int remove (Deque<Integer> que) {
        if (que.isEmpty()) {
            return -1;
        }
        return que.removeLast();
    }

    private static int getIsEmpty (boolean isEmpty) {
        return isEmpty ? 1 : 0;
    }

    private static int getFrontNum (Deque<Integer> que) {
        if (que.isEmpty()) {
            return -1;
        }
        return que.peekLast();
    }

    private static int getBackNum (Deque<Integer> que) {
        if (que.isEmpty()) {
            return -1;
        }
        return que.peekFirst();
    }
}
