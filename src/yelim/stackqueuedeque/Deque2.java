package yelim.stackqueuedeque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

// 각 if문 마지막에 continue를 했을 때, 1304 ms
// continue가 없을 때, 1296 ms
// continue를 넣는다고 해서 큰 차이는 없음
public class Deque2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i < N;i++) {
            String str = br.readLine();

            if(str.startsWith("1")) {
                String[] num1 = str.split(" ");
                dq.offerFirst(Integer.parseInt(num1[1]));
                continue;
            }
            if(str.startsWith("2")) {
                String[] num2 = str.split(" ");
                dq.offerLast(Integer.parseInt(num2[1]));
                continue;
            }
            if(str.equals("3")) {
                if(!dq.isEmpty()) {
                    sb.append(dq.pollFirst()).append("\n");
                }else {
                    sb.append("-1\n");
                }
                continue;
            }
            if(str.equals("4")) {
                if(!dq.isEmpty()) {
                    sb.append(dq.pollLast()).append("\n");
                }else {
                    sb.append("-1\n");
                }
                continue;
            }
            if(str.equals("5")) {
                sb.append(dq.size()).append("\n");
                continue;
            }
            if(str.equals("6")) {
                if(!dq.isEmpty()) {
                    sb.append("0\n");
                }else {
                    sb.append("1\n");
                }
                continue;
            }
            if(str.equals("7")) {
                if(!dq.isEmpty()) {
                    sb.append(dq.peekFirst()).append("\n");
                }else {
                    sb.append("-1\n");
                }
                continue;
            }
            if(str.equals("8")) {
                if(!dq.isEmpty()) {
                    sb.append(dq.peekLast()).append("\n");
                }else {
                    sb.append("-1\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
