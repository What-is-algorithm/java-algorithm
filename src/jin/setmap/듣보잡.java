package jin.setmap;

import java.io.*;
import java.util.*;

// [S4] 1764. 듣보잡
public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int N = data[0];
        final int M = data[1];

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String person = br.readLine();
            if (set.contains(person)) {
                ans.add(person);
            }
        }

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i == ans.size() - 1) continue;
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
