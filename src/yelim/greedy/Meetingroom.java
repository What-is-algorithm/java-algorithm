package yelim.greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Meetingroom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의 수
        int N = Integer.parseInt(br.readLine());
        // 회의 배열
        int[][] meet = new int[N][2];

        for(int i=0;i < N;i++) {
            String[] tm = br.readLine().split(" ");
            int start = Integer.parseInt(tm[0]);
            int end = Integer.parseInt(tm[1]);

            meet[i][0] = start;
            meet[i][1] = end;
        }

        // 회의 종료 시간이 빠를 수록 더 많은 회의를 할 수 있으므로
        // 회의 종료 시간 기준 오름 차순
        Arrays.sort(meet, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1]; // 종료 시간이 같을 경우, 시작 시간 기준으로 오름 차순
            }
        });

        for(int[] m:meet) {
            System.out.println(Arrays.toString(m));
        }

        int cnt = 1;
        int[] std = meet[0]; // 기준 회의
        for(int j=1;j < meet.length;j++) { // 회의 종료 시간 기준 오름 차순으로 정렬되어 있으므로 하나씩 확인
            if(std[1] <= meet[j][0]) { // 기준 회의 이후에 시작하는 회의일 경우, 증가
                cnt++;
                std = meet[j];
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
