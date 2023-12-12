package yelim.setmap;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Stringset {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        // 문자열 개수
        int N = Integer.parseInt(nm[0]);
        // 소문자로만 이루어진 중복 없는 문자열 저장
        HashSet<String> set = new HashSet<>();
        for(int  i=0;i < N;i++) {
            set.add(br.readLine());
        }

        // 검사할 문자열 개수
        int M = Integer.parseInt(nm[1]);
        int cnt = 0;
        for(int j=0;j < M;j++) {
            if(set.contains(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
