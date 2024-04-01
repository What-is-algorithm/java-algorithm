package jin.class4_2;

import java.util.*;

public class 곱셈_1629 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        long A = Long.parseLong(data[0]);
        long B = Long.parseLong(data[1]);
        long C = Long.parseLong(data[2]);

        System.out.println(pow(A, B, C));
        sc.close();
    }

    private static long pow(long A, long B, long C) {
        if (B == 1) return A % C;

        long half = pow(A, B / 2, C);

        if (B % 2 == 1) {
            return A * (half * half % C) % C;
        }

        return half * half % C;
    }
}
