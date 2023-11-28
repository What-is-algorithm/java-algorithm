package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S3] 12789. 도키도키 간식드리미
// 17%정도쯤에서 틀림 -> 무엇이 문제일까?
// if (idx == target) pass else list.add(idx);
// age = stack.pop()
// while (!stack.isEmpty()):
// now = stack.pop();
// if (now != age + 1) return false
// else age = now
public class 도키도키간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> stack = new ArrayList<>();

        int target = 1;
        int idx = 0;
        while (idx < N) {
            int data = Integer.parseInt(st.nextToken());
            if (data == target) {
                target++;
            } else {
                stack.add(data);
            }
            idx++;
        }

        System.out.println(stack.isEmpty() ? "Nice" :
                isGetSnack(stack, target) ? "Nice" : "Sad");
        br.close();
    }

    private static boolean isGetSnack(List<Integer> stack, int target) {
        while (!stack.isEmpty() && stack.get(stack.size() - 1) == target) {
            target = stack.remove(stack.size() - 1) + 1;
        }
        return stack.isEmpty();
    }
}