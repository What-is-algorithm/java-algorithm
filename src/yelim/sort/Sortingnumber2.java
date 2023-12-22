package yelim.sort;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Sortingnumber2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000000
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i < N;i++) {
            int num = Integer.parseInt(br.readLine());
            heap.add(num); // 우선 순위큐 삽입 O(logN)
        }

        for(int j=0;j < N;j++) {
            sb.append(heap.poll()).append(" "); // 우선 순위큐 삭제(꺼낼 때) O(logN)
        }
        System.out.println(sb);
        br.close();

        // 입력을 넣는 반복문 -> O(N), 최악일 때, 1000000
        // 출력을 하는 반복문 -> O(N), 최악일 때, 1000000
        // 입력 + 출력만 해도 2000000
        // 1초에 1억번 연산한다고 한다면 정렬에는 O(NlogN)이어야 할지
        // O(NlogN) -> 힙정렬, 병합정렬
        // 힙정렬 : 힙 자료구조를 기반으로 구현된 우선순위 큐 자료구조 이용하기
        // 오름 차순이므로 최소힙 사용한다.
    }
}