package yelim.graph;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Hideseek {
    static int N;
    static int K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");

        // 수빈이가 있는 위치
        N = Integer.parseInt(nk[0]);
        // 동생이 있는 위치
        K = Integer.parseInt(nk[1]);

        // 배열 초기화
        // 각 점을 인덱스로 값을 각 점에서 수빈이 위치에서 동생을 찾으러 가는 시간이 저장
        arr = new int[100001];

        System.out.println(bfs(N));
    }

    static int bfs(int N) {
        Queue<Integer> q = new LinkedList<>();

        q.add(N);
        int idx = N;
        arr[idx] = 1;
        while(!q.isEmpty()) {
            int tmp = q.poll();

            // 동생의 위치에 도착한 경우
            // 시작 위치에서 1초로 시작하였으므로 -1을 한다.
            if(tmp == K) {
                return arr[tmp] - 1;
            }else if(tmp - 1 >= 0 && arr[tmp - 1] == 0) {
                // 인덱스 tmp - 1인 경우, 수직선 범위 안이고 아직 방문하지 않은 위치(0)라면
                // 인덱스 tmp - 1인 위치로 가는 시간은 1초가 걸리므로
                // 인덱스 tmp로 까지 걸린 시간 + 1초
                arr[tmp - 1] = arr[tmp] + 1;
                // 이동한 위치에서 다시 탐색(이 위치까지 몇초 걸리는지)
                q.add(tmp - 1);
            }else if(tmp + 1 <= 100000 && arr[tmp + 1] == 0) {
                // 인덱스 tmp + 1인 경우, 수직선 범위 안이고 아직 방문하지 않은 위치(0)라면
                // 인덱스 tmp + 1인 위치로 가는 시간은 1초가 걸리므로
                // 인덱스 tmp로 까지 걸린 시간 + 1초
                arr[tmp + 1] = arr[tmp] + 1;
                // 이동한 위치에서 다시 탐색(이 위치까지 몇초 걸리는지)
                q.add(tmp + 1);
            }else if(2 * tmp <= 100000 && arr[2 * tmp] == 0) {
                // 인덱스 2 * tmp인 경우, 수직선 범위 안이고 아직 방문하지 않은 위치(0)라면
                // 인덱스 2 * tmp인 위치로 가는 시간은 1초가 걸리므로
                // 인덱스 tmp로 까지 걸린 시간 + 1초
                arr[2 * tmp] = arr[2 * tmp] + 1;
                // 이동한 위치에서 다시 탐색(이 위치까지 몇초 걸리는지)
                q.add(2 * tmp);
            }
        }
        return -1;
    }
}
