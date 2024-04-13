package jin.class4_2;

import java.io.*;
import java.util.*;

public class 알파벳_1987 {

    static int N, M;
    static char[][] data;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        data = new char[N][M];

        for (int i = 0; i < N; i++) {
            String in = br.readLine().trim();
            data[i] = in.toCharArray();
        }
        br.close();

        dfs(0, 0, new HashSet<>());
        System.out.println(result);
    }

    private static void dfs(int y, int x, Set<Character> visited) {
        if (y < 0 || x < 0 || y >= N || x >= M) return;

        char c = data[y][x];
        if (visited.contains(c)) return;
        visited.add(c);

        result = Math.max(result, visited.size());

        dfs(y + 1, x, visited);
        dfs(y, x + 1, visited);
        dfs(y - 1, x, visited);
        dfs(y, x - 1, visited);
        visited.remove(c);
    }
}
