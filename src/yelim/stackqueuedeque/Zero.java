package yelim.stackqueuedeque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        // 0이 나올 경우, 최근에 쓴 수를 삭제하기 위한 스택
        Stack<Integer> st = new Stack<>();

        for(int i=0;i < K;i++) {
            int num = Integer.parseInt(br.readLine());

            if(!st.empty() && num == 0) {
                st.pop();
            } else {
                st.push(num);
            }
        }

        // 최종적으로 적어 낸 수의 합
        int sum = 0;
        while(!st.empty()) {
            sum += st.pop();
        }
        System.out.println(sum);
        br.close();
    }
}
