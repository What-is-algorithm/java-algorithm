package jin.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 깊이우선탐색1 {
    static int cnt = 1;
    static List<List<Integer>> graph;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0], m = input[1], r = input[2];
        seq = new int[n+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        seq[r] = cnt;
        dfs(r);
        for (int i = 1; i <= n; i++) {
            System.out.println(seq[i]);
        }
    }

    private static void dfs(int start) {
        seq[start] = cnt;
        for(int node : graph.get(start)) {
            if (seq[node] == 0) {
                cnt++;
                dfs(node);
            }
        }
    }
}
