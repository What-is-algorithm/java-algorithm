package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Todo 하나의 스티커를 고르면, 해당 스티커를 기준으로 상/하/좌/우에 위치한 스티커는 고를 수 없음
// Todo 백트래킹이 아니라 DP네.. -> 왤까?
// Todo 또, 어떻게 해당 값의 상/하/좌/우를 탐색하면서 가장 큰 값을 얻을 수 있을까?

// Todo 내가 방금 뗀 스티커의 상/하/좌/우를 고려하는 건 쉽지 않음 -> (1) 처음 스티커를 뗀 다음에는 상/하/좌/우에 대해 탐색할 때 일정한 패턴이 없음
// Todo 즉, 패턴이 없다는 건 알고리즘을 풀 때 해당 접근법은 구현을 못함
// Todo ex. A B C -> .. 1 A B C 2 ..  -> A의 스티커를 뗀다면 B의 점수를 누적시키지 못함 -> 이때, C는 다음 스티커보다 점수가 큰지 모르므로 뗄 수 없음
// Todo 즉, C는 다음 스티커, 그 다음 스티커, 다다음 스티커보다 값이 큰지 알 수가 없으므로 .. A를 기준으로 다음 스티커를 뗄지 파악하기는 어려움
// Todo 현재 값을 기준으로 오른쪽의 값은 뗄지 말지 알기 어려움
// Todo C를 기준으로 이전 스티커를 뭘 뗄지는 파악하기 쉬움 -> 이전 데이터를 활용해서 현재 값을 업데이트 -> DP

// Todo 2개의 DP (이때, 나는 모든 스티커를 탐색해야 한다고 생각했으므로 2차원 배열을 생각)
// Todo ex. DP 1) 50 -> 10을 뗄지말지를 위해 왼쪽 하단 대각선 자체 30을 고려
// Todo ex. DP 2) 30 -> 50을 뗄지말지를 위해 왼쪽 상단 대각선 자체 50을 고려
// Todo 현재 인덱스에서 다음 인덱스를 비교하는 것이 아니라 현재 인덱스에서 이전 인덱스들을 비교한다.
public class Sticker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력부터 처리하고 고민할래~
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i ++) {
            int n = Integer.parseInt(br.readLine());

            // 흠.. 일단 이미 분리되어 있는 형태로 받아오는게 낫지 않을까? 공백만 제거해서
            // 근데, 스티커가 항상 2행 n열로 고정되어 있다면 2차원 배열이 맞지 않나?
            // 그리고 모든 스티커를 탐색해야하니까.. 왜냐하면 한 스티커를 골랐을 때, 상/하/좌/우로 탐색을 해야하므로?
            int[][] stickers = new int[2][n];
            for (int j = 0; j < 2; j ++) {
                // Todo br.readLine()을 통해 한 행의 값들을 모두 가져옴 -> 값들에서 공백을 없애버린 후, 한 행의 모든 열들에 값들을 박아넣음
                stickers[j] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray(); // .map() : 객체 -> 객체 <-> .mapToInt() : 객체 -> int
//                StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 50 10 100 20 40을 받아옴
//                for (int k = 0; k < n; k ++) {
//                    stickers[j][k] = Integer.parseInt(st.nextToken());
//                }
            }
//            for (int[] sticker : stickers) {
//                System.out.println(Arrays.toString(sticker));
//            }


        }
    }
}
