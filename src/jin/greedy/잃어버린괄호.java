package jin.greedy;

import java.io.*;
import java.util.*;

// [S2] 1541. 잃어버린 괄호
// 최소값을 구해라? -> 뺄 값들을 최대로 만들어라
// 1. data = br.readLine().split("-")
// 2. for s in d[0].split("+") sum += s
// 3. for d in d[1:] { for s in d.split("+") -> sum -= s }
public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("-");
        int sum = 0;
//        System.out.println(Arrays.toString(data));
        for (String s : data[0].split("\\+")) {
            sum += Integer.parseInt(s);
        }

        if (data.length > 1) {
            for (int i = 1; i < data.length; i++) {
                for (String s : data[i].split("\\+")) {
                    sum -= Integer.parseInt(s);
                }
            }
        }

        System.out.println(sum);
    }
}
