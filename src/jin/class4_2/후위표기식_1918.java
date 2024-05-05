package jin.class4_2;

import java.util.*;

public class 후위표기식_1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data =  sc.nextLine().trim();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if ( c == '(') {
                stack.addLast(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    result.append(stack.removeLast());
                }
                stack.removeLast();
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    result.append(stack.removeLast());
                }
                stack.addLast(c);
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty() && (stack.peekLast() == '*' || stack.peekLast() == '/') ) {
                    result.append(stack.removeLast());
                }
                stack.addLast(c);
            } else if ('A' <= c & c <= 'Z') {
                result.append(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }

        System.out.println(result);
        sc.close();
    }
}
