package silver.stackqueuedeque;

import java.io.*;
import java.util.*;

public class JosephusProblem0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            queue.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i ++) {
                // [1, 2, 3, 4, 5, 6, 7]
                // i = 0, i < 2 (0, 1, 2)
                // [2, 3, 4, 5, 6, 7, 1]
                // i = 1
                // [3, 4, 5, 6, 7, 1, 2]
                // i = 0
                // [5, 6, 7, 1, 2, 4]
                // i = 1
                // [6, 7, 1, 2, 4, 5]
                // i = 0
                // [1, 2, 4, 5, 7]
                // i = 1
                // [2, 4, 5, 7, 1]
                // i = 0
                // [5, 7, 1, 4]
                // i = 1
                // [7, 1, 4, 5]
                // i = 0
                // [4, 5, 1]
                // i = 1
                // [5, 1, 4]
                // i = 0
                // [4, 1]
                // i = 1
                // [1, 4]
                // i = 0
                // [4]
                // i = 1
                // [4]

                // ※ k-1 번째까지 값을 하나씩 제거 후, 삽입함으로써 뒤로 보냄
                queue.add(queue.poll());
            }
            // [4, 5, 6, 7, 1, 2] / [3]
            // [7, 1, 2, 4, 5] / [3, 6]
            // [4, 5, 7, 1] / [3, 6, 2]
            // [1, 4, 5] / [3, 6, 2, 7]
            // [1, 4] / [3, 6, 2, 7, 5]
            // [4] / [3, 6, 2, 7, 5, 1]
            // [] / [3, 6, 2, 7, 5, 1, 4]

            // ※ k번째 값을 ArrayList에 저장
            answer.add(queue.poll());
        }

        System.out.print("<");
        for (int i = 0; i < answer.size(); i ++) {
            // <3
            // <3, 6
            // <3, 6, 2
            // <3, 6, 2, 7
            // <3, 6, 2, 7, 5
            // <3, 6, 2, 7, 5, 1

            System.out.print(answer.get(i));
            // 0 != 6 -> <3,
            // 1 != 6 -> <3, 6,
            // 2 != 6 -> <3, 6, 2,
            // 3 != 6 -> <3, 6, 2, 7,
            // 4 != 6 -> <3, 6, 2, 7, 5,
            // 5 != 6 -> <3, 6, 2, 7, 5, 1,

            if (i != answer.size() - 1)
                System.out.print(", ");
        }

        // <3, 6, 2, 7, 5, 1, 4>
        System.out.print(">");

        br.close();
    }
}
