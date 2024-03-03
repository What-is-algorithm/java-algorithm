package jin.class4;

import java.util.*;

// [G2] 1918. 후위표기식
public class 후위표기식 {
    public static void main(String[] args) {
        // 괄호 안의처리..? stack
        // A ~ Z -> sb.append
        // '(' -> stack.push
        // 연산자 1.(연산) 2.'*' || '/' 3. '+' || '-'
        // top2-> while(!stack.isEmpty() && 우선순위 비교) {pop} -> push
        // top3 -> while(!stack.isEmpty() && != '(') {pop} -> push
        // ')' ->  while(!stack.isEmpty() && stack[-1] != '(') {pop}
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
