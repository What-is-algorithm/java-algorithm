package silver.class4;

import java.io.*;
import java.util.*;

// TODO 1. 확산되는 미세먼지의 양(A_r,c / 5) -> int[][] spreadDust = new int[r + 1][c + 1];
// TODO 2. (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다. -> dx, dy를 통해 그 먼지가 확산될 수 있는 좌표를 구하는 메서드 -> spreadDust()
// TODO 3. 확산되는 양은 A_r,c / 5 -> 한 곳당 확산될 먼지의 양 -> Math.floor(n / 5)
// TODO 4. (r, c)에 남은 미세먼지의 양은 A_r,c - |A_r,c / 5| * (확산된 방향의 개수)
// -> 확산 후 먼지 값 = 현재 먼지 - (1번의 확산 방향 값) x (2번의 한 방향당 확산될 먼지의 양)
// TODO ex. 10 = 46 - (4 x (46 / 5)) = 46 - (4 * 9) = 36 (4 / 4 / 4 / 4)
// TODO 5. 현재 먼지의 양 + 확산된 먼지의 양
// TODO ex. 30 -> 하좌우 -> 30 - (3 * (30 / 5)) = 30 - 18 = 12
// ex. .. (탭으로 대체)
// -> 위쪽 공기 청정기의 방향 : 반시계방향 <-> 4방향 탐색 (싱하좌우)

// TODO 4방향 탐색 = BFS
public class FineDustBye {
    public static void main(String[] args) throws IOExcep발tion {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 입력부터 처리하고 생각하자..
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 예제 1을 그림으로 그려보는 중

    }
}
