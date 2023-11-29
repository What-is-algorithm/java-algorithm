package silver.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstalling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 초기화
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] house = new int[n];

        // 2. 입력
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        // 3. 정렬
        Arrays.sort(house);

        // 4. 탐색 및 출력
        System.out.println(getMaxDistance(n, c, house));
        br.close();
    }

    /*
     * 가장 인접한 두 공유기 사이의 거리가 최대일 경우를 구하기
     * = 설치해야 할 공유기의 개수(= c)와 같은 거리 중 최대로 가질 수 있는 최소 거리 (마지막으로 설치한 곳 + 최대 거리)
     * = 최소 거리 중 최대 값 찾기
     *
     * lower bound(= 하한 값) : 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
     * = lower bound로 찾고자 하는 값을 기준으로 점진적으로 증가시켜나가면서 찾고자 하는 값이 마지막으로 나타나는 위치(여기선 값), 즉 최댓값을 찾는 것
     * m (구하고자 하는 값) : 거리(값) <-> 인덱스
     */


    private static int getMaxDistance(int houseCnt, int target, int[] house) {
        int l = 1; // 거리(값)의 초기값
        int r = house[houseCnt - 1];
        int maxDistance = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int routerPosition = 0;
            int installRouter = 1;

            for (int i = 1; i < houseCnt; i++) {
                if (house[i] - house[routerPosition] >= m) {
                    routerPosition = i;
                    installRouter++;
                }
            }

            if (target <= installRouter) { // lower bound -> "<="
                // 가지고 있는 공유기(= 설치 해야 할 공유기)가 설치한 공유기의 수보다 작다면
                // 너무 많이 설치했다는 것 = 최소 거리를 작게 잡았다는 것 = 최소 거리를 늘려야 함
                maxDistance = m;
                l = m + 1;
            } else {
                r = m - 1; // target > installRouter
            }
        }

        return maxDistance;
    }
}