package jin.setmap;

import java.io.*;
import java.util.*;

// [S4] 14425. 문자열 집합
// "집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다."
// map -> 10,000 + 10,000
public class 문자열집합 {
    public static void main(String[] args) throws IOException{
        Map<String, Boolean> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), true);
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            ans += map.containsKey(s) ? 1 : 0;
        }

        System.out.println(ans);
        br.close();
    }
}
