package jin.class4_2;

import java.io.*;
import java.util.*;

public class 거짓말_1043 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        while (truthCnt-- > 0) {
            int truth = Integer.parseInt(st.nextToken());
            parent[truth] = 0;
        }

        List<Integer>[] parties = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            parties[i].add(first);
            for (int j = 1; j < partyPeople; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);
                union(first, person);
            }
        }

        int result = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (find(person) == find(0)) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) result++;
        }

        System.out.println(result);
        br.close();
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
