# 24511 queuestack

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] typeArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] elements = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < elements.length; i++) {
            boolean isQueue = typeArr[i] == 0;
            if (isQueue) deque.addFirst(elements[i]);
        }

        StringBuilder sb = new StringBuilder();
        int len2 = Integer.parseInt(br.readLine());
        int[] elements2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < elements2.length; i++) {
            deque.addLast(elements2[i]);
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}
```

