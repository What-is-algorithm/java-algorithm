package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S4] 9012. 괄호
public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            List<Character> list = new ArrayList<>();
            String input = br.readLine();
            if (isCorrectBracket(list, input)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isCorrectBracket(List<Character> list, String input) {
        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == ')') {
                if (list.isEmpty()) {
                    return false;
                } else {
                    list.remove(list.size()-1);
                }
            }

            if (input.charAt(j) == '(') {
                list.add('(');
            }
        }

        return list.isEmpty();
    }
}
