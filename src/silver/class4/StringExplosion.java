package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// TODO 1. 문자열이 폭발 문자열을 포함 -> stack.remove() + 남은 문자열은 합쳐짐
// TODO 2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있음
// TODO 3. 폭발은 폭발 문자열이 없을 때까지 계속 -> while(!stack.isEmpty())
// TODO 4. 문자열 = 폭발 문자열(단, 폭발 문자열이 항상 연속적일 필요는 없음) -> private static String _ { return "FRULA" }
public class StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String standard = br.readLine();
        String explosion = br.readLine();

        Deque<Character> deq = new ArrayDeque<>();
        // 1. 기존 문자열을 대상으로 스택에 문자 or 문자열로써 문자 하나씩 삽입한다.
        // 2. "CC44"를 어떻게 보면 C4 C4로 볼 수 있을까? -> 이게 핵심같은데
        for (int i = 0; i < standard.length(); i ++) {
            deq.push(standard.charAt(i));
        }


    }
}
