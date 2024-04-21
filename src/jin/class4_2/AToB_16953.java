package jin.class4_2;

import java.util.*;

public class AToB_16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        // pq ? greedy?
        int result = 1;
        while (b > a) {
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b /= 10;
            } else {
                result = -1;
                break;
            }
            result++;
        }

        System.out.println(b == a ? result : -1);
    }
}
