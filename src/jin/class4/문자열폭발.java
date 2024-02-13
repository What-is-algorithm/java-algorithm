package jin.class4;

import java.io.*;
import java.util.*;

// [G4] 9935. 문자열 폭발

public class 문자열폭발 {
    // 1. 스택에 넣는다.
    // 2. 폭발 문자열 마지막 알파벳 && 길이 >= 폭발 문자열 && ?
    // 3. 길이만큼 스택에서 뺴서
    // 4. temp 문자열에 넣고 reverse
    // 5. 같지 않으면 스택에 다시 넣기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine().trim();
        String boom = br.readLine().trim();

        List<Character> list = new LinkedList<>();
        char lastChar = boom.charAt(boom.length() - 1);

        for (int i = 0; i < data.length(); i++) {
            list.add(data.charAt(i));

            if (data.charAt(i) == lastChar && list.size() >= boom.length()) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < boom.length(); j++) {
                    temp.append(list.remove(list.size() - 1));
                }
                temp = reverse(temp.toString());

                if (!Objects.equals(temp.toString(), boom)) {
                    for (int j = 0; j < boom.length(); j++) {
                        list.add(temp.charAt(j));
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : list) {
            result.append(c);
        }
        System.out.println(result.length() > 0 ? result : "FRULA");
        br.close();
    }

    private static StringBuilder reverse (String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb;
    }
}
