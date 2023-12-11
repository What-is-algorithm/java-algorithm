package jin.setmap;

import java.io.*;
import java.util.*;

// [S5] 7785. 회사에 있는 사람
// HashMap -> 삽입 삭제 O(1) -> 마지막 정렬을 위해 NlogN -> 1_000_000 + 1_000_000 * log(1_000_000)
// TreeMap -> O(logN) -> NlogN -> 1_000_000 * log(1_000_000)
// 1_000_000 + 1_000_000 * 20
public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        Map<String, Boolean> unsortedMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            String ca = data[1];
            switch (ca) {
                case "enter":
                    unsortedMap.put(data[0], true); break;
                case "leave":
                    if (unsortedMap.containsKey(data[0])) unsortedMap.remove(data[0]); break;
            }
        }

        Map<String, Boolean> ans  = new TreeMap<>((o1, o2) ->
                o2.compareTo(o1) != 0 ? o2.compareTo(o1) : customReverseOrder(o1, o2));
        ans.putAll(unsortedMap);
        StringBuilder sb = new StringBuilder();
        for (String s : ans.keySet()) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int customReverseOrder(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            return s1.charAt(i) - s2.charAt(i) > 0 ? 1 : -1;
        }
        return s1.compareTo(s2);
    }
}
