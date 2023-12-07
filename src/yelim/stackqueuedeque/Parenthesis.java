package yelim.stackqueuedeque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis {
    // 괄호의 짝이 맞게 들어오는지 확인하기 위한 스택
    static Stack<String> st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i < N;i++) {
            // 한 문자열에 대해 스택 초기화
            st = new Stack<>();
            String[] str = br.readLine().split("");
            sb.append(check(str) + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    static String check(String[] str) {
        for(int j=0;j < str.length;j++) {
            if(str[j].equals("(")) {
                st.push("(");
            }
            if(!st.empty() && str[j].equals(")")) {
                st.pop();
            } else if(st.empty() && str[j].equals(")")) { // 스택에 아무것도 없는데 ")"이 들어올 경우, VPS X
                return "NO";
            }
        }
        // 괄호 짝에 맞게 스택에서 모두 삭제되었다면
        if(st.empty()) {
            return "YES";
        }else {
            return "NO";
        }
    }
}
