package jin.setmap;

import java.util.*;
import java.io.*;

// [S4] 1620. 나는야 포켓몬 마스터 이다솜
public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        final int N = Integer.parseInt(data[0]);
        final int M = Integer.parseInt(data[1]);

        Map<String, Integer> strToInt = new HashMap<>();
        Map<Integer, String> intToStr = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String poketmon = br.readLine();
            strToInt.putIfAbsent(poketmon, i);
            intToStr.putIfAbsent(i, poketmon);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String test = br.readLine();
            if (isNumeric(test)) { // 572ms
                sb.append(intToStr.get(Integer.valueOf(test)));
            /*if (test.matches("\\d+")) { // 868ms
                sb.append(intToStr.get(Integer.valueOf(test)));*/
            } else {
                sb.append(strToInt.get(test));
            }
            if (i == M-1) continue;
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isNumeric(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
