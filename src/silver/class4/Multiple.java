package silver.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiple {
    private static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // Todo 각각의 값들은 모두 int 범위 내의 값들이지만, "이하"이기 때문에 a를 b번 이상 곱한다면 int형의 범위를 벗어날 수 있다고 판단하고 long 타입으로 초기화 및 선언
        // Todo 근데, 생각해보니 a 말고는 상관없을듯
        // Todo a는 반복 계산을 수행하는 반면, b는 a를 몇 번 반복을 할 것인지의 수단으로써만 사용이 되고 c는 단 한 번만 나눌 것이므로 int형의 범위에 걸쳐있어도 상관이 없을테니까
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // Todo (1) a * b는 단순히 a와 b를 구하는 것이므로 x
        // Todo (2) 단순히 곱하면 long 형의 범위 또한 초과해버리므로 x
        // Todo (3) 누적합(또는 누적곱)을 사용하면 어떨까?
        // Todo (4) 거듭제곱은? -> (3)과 (4) 모두 a, b, c가 각각 2,147,483,647일 경우 long형의 범위(~9,223,372,036,854,775,807)을 벗어날 수 있음
        // Todo ex. 2,147,483,647 * 2,147,483,647 = 4,611,900,762,120,609
        // Todo (5) 이 문제는 거듭제곱을 활용한 분할정복(지수 법칙) 및 모듈러 연산(한 수를 나눠서 나머지를 구하는 연산)을 통해 구현해야 함

        System.out.println(pow(a,b));
        br.close();
    }

    // Todo 지수 법칙(지수를 반으로 나눠서 한 번만 구한 후, 곱하기) 및 모듈러 연산(나머지를 구하기 위해 나눠줄 때, long형의 범위를 고려할 것)
    // Todo a^(n.m) = a^n * a^m = a^(n+m)
    // ex. a^4 = a^2 * a^2 = a^(2+2)
    // Todo a는 초깃값일 뿐이고, 메서드의 결과값을 값으로 도출하므로 메서드의 반환 타입이 long인 것이 중요
    private static long pow(long a, int b) {
        if (b == 1) { // b가 1일 경우, 즉 지수가 1이므로 바로 나머지를 구해서 리턴
            return a % c;
        }

        // ex. a^10 = a^5 * a^5 = (a^2 * a^2 * a) * (a^2 * a^2 *a)
        long tmp = pow(a, b / 2); // ex. a^4라면 a^2 * a^2의 조합으로 표현될 수 있으므로 a^2 구하기

        if (b % 2 == 1) { // 이때, b가 홀수라면, 즉 a의 지수가 홀수라면 항상 a^(b/2) * a^(b/2) * a의 조합으로 표현됨
            // System.out.println((tmp * tmp) * a % c);
            return (tmp * tmp % c) * a % c; // 또한, tmp * tmp * a % c는 tmp를 구하기 위한 a의 값이 b만큼 곱했을 경우, long형의 범위를 초과한다면 결과값에 % c를 수행해도 올바른 값이 나오지 않음. 따라서 연산 도중에 %c를 수행함으로써 올바른 값 구하기
        }
        return tmp * tmp % c;
    }
}
