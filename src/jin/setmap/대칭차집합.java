package jin.setmap;

import java.io.*;
import java.util.*;

// [S4] 1269. 대칭 차집합
// (setA.size() - 교집합.size()) + (setB.size() - 교집합.size())
public class 대칭차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int aSize = setA.size();
        int bSize = setB.size();
        setA.retainAll(setB);
        int commonSize = setA.size();

        System.out.println((aSize - commonSize) + (bSize - commonSize));
        br.close();
    }
}
