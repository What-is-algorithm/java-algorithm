package yelim.solvedac.class4;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class HideAndSeek2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nb = br.readLine().split(" ");
        // 수빈이의 위치 N (0 ≤ N ≤ 100,000)
        // 수빈이의 이동 방식 :
        // -> 걷는다면 1초 후에 X-1 또는 X+1로 이동
        // -> 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
        int N = Integer.parseInt(nb[0]);
        // 동생의 위치 K
        int K = Integer.parseInt(nb[1]);

        // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초인지
        // 가장 빠른 시간으로 찾는 방법이 몇 가지 있는지
        // 4초, 2가지 -> 4초 안에 동생을 찾는 방법이 2가지

        // 해당 위치의 방문 확인을 시간으로 비교해야 함
        int[] time = new int[100001];
        // 어떤 위치에 방문할 때, 동일한 시간으로 방문한 위치는 큐에 넣기(더 늦은 시간에 도착한 시간을 제외)
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        int cnt = 0;
        int second = 0;
        int[] move = {1, -1, 2};

        if(N == K) {
            cnt++;
            System.out.println(time[K]); // 최단 소요 시간
            System.out.println(cnt); // 방법 가지수
            return;
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i=0;i < move.length;i++) {
                int next = move[i];
                if(i == 2){
                    next = now * move[i];
                }else {
                    next = now + move[i];
                }

                // next가 범위 밖이거나, 이미 방문한 지점인데 기존 소요 시간보다 오래 걸린다면 X
                if(next < 0 || next > 100000 || (time[next] != 0 && time[next] < time[now] + 1)) {
                    continue;
                }

                time[next] = time[now] + 1; // 소요 시간 저장
                q.add(next);

                if (next == K) cnt ++;
            }
        }

        System.out.println(time[K]);
        System.out.println(cnt);
    }
}
