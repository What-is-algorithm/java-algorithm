package yelim.greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gasstation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 수
        int N = Integer.parseInt(br.readLine());

        // 두 도시를 연결하는 도로의 길이
        String[] km = br.readLine().split(" ");
        int[] road = new int[km.length];

        // 각 도시의 리터당 가격
        String[] l = br.readLine().split(" ");
        long[] city = new long[l.length - 1];

        for(int i=0;i < (N - 1);i++) {
            road[i] = Integer.parseInt(km[i]);
            city[i] = Long.parseLong(l[i]);
        }

        // 인덱스
        int j = 0;
        // 총 비용
        long sum = 0;
        // 계산할 도로 길이
        long totr = road[0];
        // 기준 도시
        long std = city[0];

        // 기준 도시와 기준 도시 바로 다음 도시의 주유 값을 비교
        // 기준 도시보다 다음 도시가 쌀 경우, 다음 도시로 가기 위해 주유
        // 기준 도시보다 다음 도시가 비쌀 경우, 다음 도시 이후 도시에서 주유
        while(j < (N - 1)) {
            // 마지막 도시라면
            if(j + 1 == N - 1) {
                sum += std * totr;
                break;
            }
            // 기준 도시 다음 도시
            long c = city[j + 1];

            // 기준 도시보다 가격이 쌀 경우,
            if(std >= c) { // 그 도시까지 가기 위해 기준 도시에서 주유
                sum += std * totr;
                j++; // 다음 도시로 넘어감
                std = city[j];
                totr = road[j];
            }
            // 기준 도시보다 가격이 비쌀 경우,
            else if(std < c) {
                j++;
                totr += road[j]; // 그 도시에서 주유하기 위해 주유할 양 저장
            }
        }

        System.out.println(sum);
        br.close();
    }
}
