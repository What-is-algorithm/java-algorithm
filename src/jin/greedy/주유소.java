package jin.greedy;

import java.io.*;
import java.util.*;

// [S3] 13305. 주유소
// cost = roads[i] * (min cost -> Math.min(cost, cost[i]))
public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] roads = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] cost = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int costPerLiter = 1_000_000_000;
        long rst = 0L;
        for (int i = 0; i < N - 1; i++) {
            costPerLiter = Math.min(costPerLiter, cost[i]);
            rst += (long) roads[i] * costPerLiter;
        }

        System.out.println(rst);
    }
}
