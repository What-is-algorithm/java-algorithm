package silver.stackqueuedeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        int t = Integer.parseInt(br.readLine());

        // 2. 로직
        for (int i = 1; i < t + 1; i++) {
            String[] brackets = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            for (int j = 0; j < brackets.length; j++) {
                if (brackets[j].equals("(")) {
                    stack.push("(");
                } else {
                    if (stack.isEmpty()) {
                        stack.push(")"); // 이 부분을 개선하고 싶은데..
                        break;
                    }
                    if (stack.peek() == "(") stack.pop();
                }
            }

            // 3. 출력
            if (!stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

        br.close();
    }
}
