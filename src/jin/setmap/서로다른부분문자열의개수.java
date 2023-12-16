package jin.setmap;

import java.io.*;
import java.util.*;

// [S3] 11478. 서로 다른 부분 문자열의 개수
public class 서로다른부분문자열의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        Set<String> ans = new HashSet<>();

        for (int i = 0; i < data.length(); i++) {
            for (int j = i; j < data.length(); j++) {
                ans.add(data.substring(i, j + 1));
            }
        }

        System.out.println(ans.size());
        br.close();
    }
}
