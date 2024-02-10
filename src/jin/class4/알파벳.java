package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 1987. 알파벳
public class 알파벳 {
    // set + dfs?
    // 1. 입력받기
    // (0, 0) dfs 출발
    // 상하좌우 이동하면서(dfs) 현재까지 나온 알파벳들과 비교해 중복 확인(set)
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] data = new String[N];
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().trim();
        }

        dfs(data, 0, 0, visited);
        System.out.println(result);
        br.close();
    }

    private static void dfs(String[] data, int y, int x, Set<Character> visited) {
        if (y < 0 || x < 0 || y >= data.length || x >= data[0].length()) return;
        char c = data[y].charAt(x);

        if (visited.contains(c)) return;
        visited.add(c);

        result = Math.max(result, visited.size());

//        System.out.printf("y=%d, x=%d, set=%s, result=%d\n", y, x, visited, result);
        dfs(data, y + 1, x, visited);
        dfs(data, y, x + 1, visited);
        dfs(data, y - 1, x, visited);
        dfs(data, y, x -1, visited);

        visited.remove(c);
    }
}
