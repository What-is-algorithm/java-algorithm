package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S4] 4949. 균형잡힌 세상
public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while (true) {
            input = br.readLine();
            List<Character> list = new ArrayList<>();

            if (input.equals(".")) {
                break;
            }

            if (isCorrectBracket(list, input)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isCorrectBracket(List<Character> list, String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[') {
                list.add(c);
            }

            if (c == ')') {
                if (!list.isEmpty() && list.get(list.size() - 1) == '(') {
                    list.remove(list.size() - 1);
                } else {
                    return false;
                }
            }

            if (c == ']') {
                if (!list.isEmpty() && list.get(list.size() - 1) == '[') {
                    list.remove(list.size() - 1);
                } else {
                    return false;
                }
            }
        }

        return list.isEmpty();
    }
}