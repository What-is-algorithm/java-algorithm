package yelim.stackqueuedeque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

// 요세푸스 문제와 비슷한 문제
// 하지만 한 방향으로만 움직이지 않고 두 방향(+/-)으로 움직이며 제거하므로
// 덱을 사용한다.
public class Poppingballoon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        // 덱의 앞을 확인하는 것은 양수 방향으로 확인하며 풍선을 터뜨리는 것이고
        // 덱의 뒤를 확인하는 것은 음수 방향으로 확인하며 풍선을 터뜨리는 것이다.
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i=0;i < N;i++) { // 덱에 풍선 번호와 풍선 속 숫자 배열 저장
            int[] tmp = {i+1, Integer.parseInt(num[i])};
            dq.offerLast(tmp);
        }

        // 제일 처음에 1번 풍선 터뜨리기
        int[] first = dq.pollFirst();
        sb.append(first[0]).append(" ");
        // 풍선 속 종이 번호
        // 1번 풍선 속 숫자로 초기화
        int bn = first[1];
        while(dq.size() > 1) {
            int[] blln;
            if(bn > 0) { // 풍선 속 숫자가 양수 방향이라면
                move(dq, bn - 1); // 풍선 속 숫자만큼 양수 방향으로 덱에서 풍선들을 움직인다.
                blln = dq.pollFirst(); // 양수 방향이므로 덱의 앞부분에 있던 풍선이 터진다.
            }else { // 풍선 속 숫자가 음수 방향이라면
                move(dq, bn + 1); // 풍선 속 숫자만큼 음수 방향으로 덱에서 풍선들을 움직인다.
                blln = dq.pollLast(); // 음수 방향이므로 덱의 뒷부분에 있던 풍선이 터진다.
            }
            sb.append(blln[0]).append(" ");
            bn = blln[1];
        }
        int[] last = dq.pollFirst();
        sb.append(last[0]);

        System.out.println(sb);
        br.close();
    }

    static void move(Deque<int[]> dq, int n) { // n만틈 덱에서 풍선을 움직이는 함수
        if(n < 0) {
            while(n < 0) {
                dq.offerFirst(dq.pollLast());
                n++;
            }
        }else {
            while(n > 0) {
                dq.offerLast(dq.pollFirst());
                n--;
            }
        }
    }
}
