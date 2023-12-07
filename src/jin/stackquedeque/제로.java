package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S4] 10773. 제로
public class 제로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) pop(stack);
            else add(stack, n);
        }

        int rst = 0;
        for (int i = 0; i < stack.size(); i++) {
            rst += stack.get(i);
        }

        System.out.println(rst);
        br.close();
    }

    private static void add(List<Integer> stack, int num) {
        stack.add(num);
    }

    private static void pop(List<Integer> stack) {
        if (!stack.isEmpty()) {
            stack.remove(stack.size() -1);
        }
    }
}
