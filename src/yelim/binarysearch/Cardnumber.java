package yelim.binarysearch;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Cardnumber {
    static HashMap<Integer, Integer> card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자 카드 개수
        int N = Integer.parseInt(br.readLine());
        String[] nstr = br.readLine().split(" ");

        // 숫자 카드별 개수를 맵에 저장
        // 키 = 숫자 카드, 값 = 숫자 카드 개수
        card = new HashMap<>();
        for(int i=0;i < N;i++) {
            int c = Integer.parseInt(nstr[i]);

            card.put(c, card.getOrDefault(c, 0) + 1);
        }
        List<Integer> num = new ArrayList<>(card.keySet());
        Collections.sort(num);

        // 몇 개를 가지고 있는 숫자 카드인지 구할 정수 개수
        int M = Integer.parseInt(br.readLine());
        String[] mstr = br.readLine().split(" ");
        for(int j=0;j < M;j++) {
            int tmp = Integer.parseInt(mstr[j]);

            sb.append(findCard(tmp, num) + " ");
        }

        System.out.println(sb);
    }

    static int findCard(int tmp, List<Integer> num) {
        int l = 0;
        int r = num.size() - 1;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(tmp == num.get(mid)) {
                return card.get(tmp);
            }else if(tmp > num.get(mid)) {
                l = mid + 1;
            }else if(tmp < num.get(mid)) {
                r = mid - 1;
            }
        }
        return 0;
    }
}
