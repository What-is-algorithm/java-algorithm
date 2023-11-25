package yelim.greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Coin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] money = br.readLine().split(" ");

        // 동전 종류
        int N = Integer.parseInt(money[0]);
        // 만들려는 금액
        int K = Integer.parseInt(money[1]);
        // 만들려는 금액 자릿수
        int o = money[1].length();

        int[] coin = new int[N];
        for(int i=0;i < N;i++) {
            String str = br.readLine();
            coin[i] = Integer.parseInt(str);
        }

        int cnt = 0;
        // 동전 금액 입력이 오름차순으로 주어지므로 큰 동전 금액부터 확인하기 위해
        for(int j=(coin.length-1);j >= 0;j--) {
            // 동전 금액이 만들려는 금액 이하라면
            if(coin[j] <= K) {
                // 동전 금액에 따른 동전 개수 세기
                cnt += K / coin[j];
                // 위에서 계산 동전 금액을 만들어야할 금액에서 뺀다.
                K -= (K / coin[j]) * coin[j];
            }
            if(K < 0) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
