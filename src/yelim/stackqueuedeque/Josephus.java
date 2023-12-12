package yelim.stackqueuedeque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        // K번째 사람 제거
        int K = Integer.parseInt(nk[1]);
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i <= N;i++) {
            q.offer(i);
        }

        sb.append("<");
        int idx = 1;
        while(q.size() > 1) {
            if(idx == K) { // 큐에서 k번째에 있는 수를 제거한다.
                sb.append(q.poll()).append(", ");
                idx = 1; // 다시 1부터 k까지 세기 위해 idx를 1로 초기화
            }else {
                q.offer(q.poll()); // k번째가 아니므로 다시 큐의 맨 뒤로 보낸다.
                idx++;
            }
        }
        sb.append(q.poll()).append(">");

        System.out.println(sb);
        br.close();
    }
}
