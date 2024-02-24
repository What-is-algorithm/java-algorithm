package silver.class4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// TODO 1. '*' 또는 '/'를 마주했을 경우, 해당 연산자를 기준으로 -2 / + 2의 위치에 소괄호 삽입?

// TODO 이 문제는 소괄호도 쳐줘야 했던거 아니야?
// TODO (1) 우선 순위를 어떻게 할당할 것인가?
// TODO (2) 스택에 넣고 빼는 과정을 어떤 조건을 기준으로 분리할 것인가?

// TODO (1) +, - : 우선 순위 낮음
//  -> *, / : 우선 순위 높음
//  -> ( : 우선 순위 매우 높음
// TODO Q. 근데, '('가 가장 우선 순위가 높음에도 불구하고 getPriority()에는 포함이 왜 안 되는걸까?
// TODO (2) stack : 우선 순위 낮은 연산자 -> 우선 순위 높은 연산자 순서로 쌓임
// TODO Q. 그런데, 스택(LIFO)에는 '*' -> '(' -> '+' 순으로 저장이 되어 있어야 할텐데, 왜 '+' -> '(' -> '*'순으로 저장이 되어 있을까?
public class PostfixNotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infixNotation = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        char[] chars = infixNotation.toCharArray();
        for (int i = 0; i < infixNotation.length(); i++) {
            int priority = getPriority(chars[i]);

            switch (chars[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= priority) { // 현재(= 연산자)보다 큰 우선순위의 연산자를 만날 때까지 모두 pop()?
                        output.append(stack.pop());
                    }

                    stack.push(chars[i]); // pop() 이후, 삽입
                    break;

                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        output.append(stack.pop());
                    }

                    stack.pop();
                    break;

                case '(':
                    stack.push('(');
                    break;

                default:
                    output.append(chars[i]);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        System.out.println(output);
        br.close();
    }

    private static int getPriority(char ch) {
        switch (ch) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}

// https://devyoseph.tistory.com/258
