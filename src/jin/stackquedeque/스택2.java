package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S4] 28278. 스택 2
public class 스택2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int caseNum = input[0];
            switch (caseNum) {
                case 1:
                    add(stack, input[1]);
                    break;
                case 2:
                    sb.append(pop(stack)).append("\n");
                    break;
                case 3:
                    sb.append(getSize(stack)).append("\n");
                    break;
                case 4:
                    sb.append(isEmpty(stack)).append("\n");
                    break;
                case 5:
                    sb.append(peek(stack)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static void add(List<Integer> stack, int num) {
        stack.add(num);
    }

    private static int pop(List<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.remove(stack.size()-1);
    }

    private static int getSize(List<Integer> stack) {
        return stack.size();
    }

    private static int isEmpty(List<Integer> stack) {
        return stack.isEmpty() ? 1 : 0;
    }

    private static int peek(List<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.get(stack.size()-1);
    }
}
