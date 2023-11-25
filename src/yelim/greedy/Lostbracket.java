package yelim.greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lostbracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 작은 수 - 큰 수 = 작은 수
        // 55 - (50 + 40) = -35
        // 덧셈으로 이루어진 부분을 먼저 계산한 뒤 빼주기
        // 덧셈 부분만 먼저 계산하기

        // 연산자가 덧셈만 있는 문자열
        String[] plus = br.readLine().split("-");

        int sum = 0;
        // 문자열에서 맨 처음 나오는 문자는 숫자라고 되어 있지만,
        // 맨 처음 나오는 수에 대한 처리를 해주지 않으면 틀린다...
        // 맨 처음 나오는 수가 +일 경우,
        if(plus[0].contains("+")) {
            int zSum = 0;
            String[] zTmp = plus[0].split("\\+");
            for(int j=0;j < zTmp.length;j++) {
                zSum += Integer.parseInt(zTmp[j]);
            }
            sum = zSum;
        }else { // 맨 처음 나오는 수가 -일 경우,
            sum = Integer.parseInt(plus[0]);
        }

        // 덧셈으로 이루어진 것은 더하고 식의 최종 값에 뺀다.
        for(int i=1;i < plus.length;i++) {
            if(plus[i].contains("+")) {
                int plusSum = 0;
                String[] tmp = plus[i].split("\\+");
                for(int j=0;j < tmp.length;j++) {
                    plusSum += Integer.parseInt(tmp[j]);
                }

                sum -= plusSum;
            }else {
                sum -= Integer.parseInt(plus[i]);
            }
        }

        System.out.println(sum);
    }
}
