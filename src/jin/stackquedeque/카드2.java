package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S4] 2164. 카드2
public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        System.out.println(getFinalCard(que));
    }

    private static int getFinalCard(Queue<Integer> que) {
        if (que.size() == 1) {
            return 1;
        }

        while (true) {
            que.remove();
            if (que.size() == 1) {
                return que.peek();
            }
            int num = que.remove();
            que.add(num);
        }
    }
}