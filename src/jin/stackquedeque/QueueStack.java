package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S3] 24511. queuestack
// 각각의 자료구조에는 한 개의 원소가 들어있다. -> que: 박힌 돌 뺴고 자기가 차지함. stack: 만남 후 바로 이별
// que만 넣기
// 마지막 M번 반복해서
// 1. 들어오는 값 앞에 넣기
// 2. 마지막 값 빼서 출력
public class QueueStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();
        StringTokenizer stForStructure = new StringTokenizer(br.readLine());
        StringTokenizer stForNum = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stForNum.nextToken());
            if (Objects.equals(stForStructure.nextToken(), "0")) {
                que.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        final int M = Integer.parseInt(br.readLine());
        stForNum = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stForNum.nextToken());
            que.addFirst(num);
            sb.append(que.pollLast()).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
