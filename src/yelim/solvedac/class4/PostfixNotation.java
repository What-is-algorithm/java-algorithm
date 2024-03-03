package yelim.solvedac.class4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixNotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 문자열 길이 <= 100
        String str = br.readLine();
        // 연산자만 넣고 피연산자는 바로출력
        Stack<Character> st = new Stack<>();

        for (int i=0; i < str.length();i++) {
            char now = str.charAt(i);

            switch (now){
                case '+':
                case '-':
                case '*':
                case '/': // 지금 보고 있는 연산자의 우선순위보다 높은 것이 있다면 StringBuilder에 넣기
                    while (!st.isEmpty() && priority(st.peek()) >= priority(now)) {
                        sb.append(st.pop());
                    }
                    st.add(now);
                    break;
                case '(':
                    st.add(now);
                    break;
                case ')': // 여는 괄호가 아닌 다른 연산자라면 StringBuilder에 넣기
                    while(!st.isEmpty() && st.peek() != '('){
                        sb.append(st.pop());
                    }
                    st.pop();
                    break;
                default: // 피연산자는 바로 StringBuilder에 넣기
                    sb.append(now);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb);
        br.close();
    }

    // 연산자별 우선순위 리턴
    static int priority(char operator){
        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}
// https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1918-%ED%9B%84%EC%9C%84-%ED%91%9C%EA%B8%B0%EC%8B%9D-JAVA%EC%9E%90%EB%B0%94