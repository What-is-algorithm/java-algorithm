package silver.stackqueuedeque;

import java.io.*;
import java.util.*;

public class Card2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 2. 입력
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 3. 로직
        while (queue.size() > 1) {
            queue.poll();

            int tmp = 0;
            tmp = queue.peek();

            queue.poll();
            queue.add(tmp);
        }

        System.out.println(queue.peek());
        br.close();
    }
}