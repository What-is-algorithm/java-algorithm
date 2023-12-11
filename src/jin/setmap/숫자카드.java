package jin.setmap;

import java.io.*;
import java.util.*;

// [S5] 10815. 숫자 카드
// 1. Map 사용 -> map에 key를 넣고 있으면 1 없으면 0 -> 500,000 + 500,000
// 2. Set을 재밌게 사용하기 -> N개의 숫자를 Set에 넣고 M개의 숫자를 넣을 때 이전 크기와 다르면 1, 같으면 0 -> 500,000 + 500,000
// 2번이 가능한 문구 -> "두 숫자 카드에 같은 수가 적혀있는 경우는 없다."
public class 숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int size = set.size();
        final int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            set.add(Integer.parseInt(st.nextToken()));
            if(size != set.size()) {
                sb.append("0").append(" ");
                size = set.size();
                continue;
            }
            sb.append("1").append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
