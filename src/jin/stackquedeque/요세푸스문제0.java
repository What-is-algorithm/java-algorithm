package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S5] 11866. 요세푸스 문제 0
public class 요세푸스문제0 {
    // K-1 개만큼 Que에서 빼고 넣는다
    // K번째 수는 빼서 sb에 넣고 "," + " " 하기
    // que가 비어있을 때는 2번 과정 생략
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!que.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                que.offer(que.poll());
            }
            sb.append(que.poll());
            if (que.size() == 0)
                continue;
            sb.append(",").append(" ");
        }
        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}
