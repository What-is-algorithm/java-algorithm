package jin.stackquedeque;

import java.io.*;
import java.util.*;

// [S3] 12789. 도키도키 간식드리미
// 17%정도쯤에서 틀림 -> 무엇이 문제일까? -> 대기열이 비어있지 않은 상태에서 다음 사람이 대기열에 있는 경우를 배제했다!
// 인덱스 관련해서 문제가 있는 것 같지만 어떤 문제인지 알 수가 없어서 que를 사용하자.
// if (idx == target) pass else list.add(idx);
// age = stack.pop()
// while (!stack.isEmpty()):
// now = stack.pop();
// if (now != age + 1) return false
// else age = now
public class 도키도키간식드리미 {
    static int target = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            que.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> anotherLine = new ArrayList<>();
        makeAnotherLine(que, anotherLine);
        System.out.println(isPerfectOrderAboutAnotherLine(anotherLine) ? "Nice" : "Sad");
    }

    private static void makeAnotherLine(Queue<Integer> que, List<Integer> line) {
        while (!que.isEmpty()) {
            if (que.peek() == target) {
                que.poll();
                target++;
            } else {
                if (!line.isEmpty() && line.get(line.size() - 1) == target) {
                    line.remove(line.size() - 1);
                    target++;
                } else {
                    line.add(que.poll());
                }
            }
        }
    }

    private static boolean isPerfectOrderAboutAnotherLine(List<Integer> line) {
        while (!line.isEmpty()) {
            int order = line.remove(line.size() - 1);
            if (order == target) {
                target++;
            } else {
                return false;
            }
        }
        return true;
    }
}