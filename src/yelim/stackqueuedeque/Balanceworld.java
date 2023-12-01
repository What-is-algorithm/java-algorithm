package yelim.stackqueuedeque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Balanceworld {
    static Stack<String> st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(!(str = br.readLine()).equals(".")) {
            // 문자열을 괄호만 남게하기 위한 처리
            str = str.replaceAll("[a-zA-Z_0-9]", "");
            str = str.replaceAll("[.]", "");
            str = str.replaceAll("[\\s]", "");

            // 각 문자열에 대한 스택 초기화
            st = new Stack<>();
            String[] pare = str.split("");
            sb.append(check(pare) + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    static String check(String[] pare) {
        for(int i=0;i < pare.length;i++) {
            if(pare[i].equals("(") || pare[i].equals("[")) {
                st.push(pare[i]);
            }
            // 스택이 비어 있는데 닫는 괄호가 있다면 균형X
            if(st.empty() && pare[i].equals(")")) {
                return "no";
            }else if(!st.empty() && pare[i].equals(")")) {
                if(!st.peek().equals("(")) { // 스택의 맨 위에 있는 것이 짝이 맞는지
                    return "no";
                }else {
                    st.pop();
                }
            }
            if(st.empty() && pare[i].equals("]")) {
                return "no";
            }else if(!st.empty() && pare[i].equals("]")) {
                if(!st.peek().equals("[")) {
                    return "no";
                }else {
                    st.pop();
                }
            }
        }
        // 괄호 짝에 맞게 스택에서 모두 삭제되었다면
        if(st.empty()) {
            return "yes";
        }else {
            return "no";
        }
    }
}
