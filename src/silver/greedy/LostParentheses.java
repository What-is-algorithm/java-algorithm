package silver.greedy;

import java.io.*;

public class LostParentheses {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화 및 '-''을 기준으로 분리
        String[] sub = br.readLine().split("-"); // ex. [30, 70, 20+40, 10+100+30, 35]
        // 2. 변수 초기화

        /*
        * 왜 Integer.MAX_VALUE를 썼을까?
        *
        * 일반적으로 변수 초기화에는 0이 쓰입니다.
        * 예를 들어, 아래의 경우에는 int sum = 0;과 같이 쓰이겠죠.
        *
        * 그런데, 이 문제에서 식의 첫 번째 수는 항상 양수입니다.
        * 따라서 마지막 조건문에 대해 첫 번째 케이스를 제외하고 모두 else문을 거치며 - 연산을 수행합니다.
        *
        * 이 점을 기억하고, 아래의 예시를 들어보겠습니다.
        *
        * input : 23-23-23
        * String[] sum = [23, 23, 23]
        * String[] add = [23],
        *                [23],
        *                [23]
        *
        * 이때, if (sum == Integer.MAX_VALUE)는 첫 번째 수가 첫 번째 값인지 아닌지 판별합니다.
        * 즉, 첫 번째 수가 양수라는 점을 통해 첫 번째 값인지 아닌지를 파악하는 것이죠.
        *
        * 따라서 첫 번째 케이스(i = 0)에는 if (sum == 0) == true -> sum = 23가 됩니다.
        *
        * 다음으로, 두 번째 케이스(i = 1)일 때를 살펴봅시다.
        * tmp = 23, sum = 23이겠죠.
        * 이때는 else sum -= tmp == true -> sum = sum - tmp로써 0이 될거에요.
        *
        * 다음으로, 세 번째 케이스(i = 2)일 때를 보죠.
        * tmp = 23, sum = 0입니다.
        *
        * 이때, 문제 상황이 발생합니다.
        * 우리가 원하는 루트는 첫 번째 값이 아니므로 else sum -= tmp == true -> sum = -23을 기대하고 있어요.
        * 하지만, sum이 현재 0이므로..
        * 원래대로라면 첫 번째 값에 대해서만 수행되어야 할 if (sum == 0)가 true 판별되어 sum = 23이 됩니다.
        *
        * 따라서 이렇게 과정 중에 중간 결과값으로 도출이 될 수도 있는 0과 같은 값은 초기화 값으로써 쓰이는 건 바람직하지 않기에..
        * 초기값은 중간 계산 혹은 결과로 나오지 않는 수로 초기화해주기 위하여 Integer.MAX_VALUE로써 초기화를 진행한 것입니다.
        */

        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < sub.length; i++) {
            // 3. '+'을 기준으로 분리
            String[] add = sub[i].split("\\+"); // i = 0, [30] -> i = 1, [70], i = 2 -> [20, 40], ..
            int tmp = 0;

            // 4. '+'
            for (int j = 0; j < add.length; j++) {
                tmp += Integer.parseInt(add[j]); // j = 0, + 20 -> j = 1, + 20 + 40
            }

            // 5. 첫 번째 수(양수)를 제외하고, 모두 '-'
            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);
        br.close();
    }
}