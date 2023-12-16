package yelim.stackqueuedeque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class Queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] q0s1 = br.readLine().split(" ");
        String[] bi = br.readLine().split(" ");

        Deque<String> qs = new ArrayDeque<>();
        for(int i=0;i < N;i++) {
            // 자료구조가 큐일 경우만 원소가 교체되므로 큐인 경우만 저장
            if(q0s1[i].equals("0")) {
                qs.addLast(bi[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] ci = br.readLine().split(" ");

        for(int j=0;j < M;j++) {
            if(!qs.isEmpty()) { // 자료구조가 큐인 원소를 확인하기 위한
                qs.offerFirst(ci[j]);
                sb.append(qs.pollLast()).append(" ");
            }else { // 자료 구조가 스택이라면
                sb.append(ci[j]).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
