package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringExplode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열이 폭발 문자열을 포함하고 있는 경우,
        // 모든 폭발 문자열이 사라지고 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
        // 새로운 문자열에 폭발 문자열이 포함되어 있을 수 있다.
        // 폭발은 폭발 문자열이 없을 때까지 계속한다.
        // 모든 폭발이 끝난 후, 문자열 출력하고 남아있는 문자가 없다면 "FRULA" 출력
        String str = br.readLine();
        String explode = br.readLine();

        while(str.contains(explode)) {
            int point = str.indexOf(explode);

            String str1 = str.substring(0, point);
            String str2 = str.substring(point + explode.length());
            str = str1.concat(str2);
        }

        int regexSize = explode.length();

        Stack<Character> st = new Stack<>();

        for(int i=0;i < str.length();i++) {
            st.push(str.charAt(i));

            // 폭발 문자열과 길이가 같아지면 탐색 시작
            if(st.size()>= regexSize) {
                boolean flag = true;

                // st.size-regexSize부터 ~ st.size까지 탐색하여 regex와 일치하면 제거
                for(int j=0; j<regexSize; j++) {
                    if(st.get(st.size()-regexSize+j) != explode.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0; j<regexSize; j++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : st) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
        br.close();
    }
}
