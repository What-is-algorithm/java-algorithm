package jin.class4_2;

import java.util.*;

public class 문자열폭발_9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String remove = sc.nextLine();
        char lastStr = remove.charAt(remove.length() - 1);
        sc.close();

        List<Character> stack = new ArrayList<>();
        StringBuilder removeCheck = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            stack.add(c);

            if (c == lastStr && stack.size() >= remove.length()) {
                for (int j = 0; j < remove.length(); j++) {
                    char c2 = stack.remove(stack.size() - 1);
                    removeCheck.append(c2);
                }

                if (!removeCheck.reverse().toString().equals(remove)) {
                    for (int j = 0; j < removeCheck.length(); j++) {
                        stack.add(removeCheck.charAt(j));
                    }
                }
                removeCheck = new StringBuilder();
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        System.out.println(result.length() == 0 ? "FRULA" : result);
    }

}
