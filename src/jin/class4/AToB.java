package jin.class4;

import java.io.*;
import java.util.*;

// [S2] 16953. A -> B

public class AToB {

    static int suffixMaxNum = Integer.MAX_VALUE / 10;

    static class Node {
        int pos, cnt;

        public Node(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int A = Integer.parseInt(data[0]);
        int B = Integer.parseInt(data[1]);

        int result = bfs(A, B);
        System.out.println(result);
        br.close();
    }

    private static int bfs(int A, int B) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(A, 1));

        while (!que.isEmpty()) {
            Node curr = que.poll();

            if (curr.pos == B) {
                return curr.cnt;
            }

            int doubleNum = curr.pos * 2;

            if (doubleNum <= B) {
                que.add(new Node(doubleNum, curr.cnt + 1));
            }

            if (curr.pos >= suffixMaxNum) continue;

            String suffixOneStr = String.valueOf(curr.pos) + 1;
            int suffixOne = Integer.parseInt(suffixOneStr);


            if (suffixOne <= B) {
                que.add(new Node(suffixOne, curr.cnt + 1));
            }
        }

        return -1;
    }
}
