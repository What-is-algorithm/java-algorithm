package jin.codingTest;

import java.util.*;

public class KRACK {
    static Set<String> hopeNumSet = new HashSet<>();
    static Set<String> existNumSet = new HashSet<>();

    public static void main(String[] args) {
        String hope_number = "123-4XX";
        String[] exist_number = new String[]{
                "123-XX0",
                "XXX-4X1",
                "123-4X2",
                "123-4X3",
                "123-4X4",
                "123-4X5",
                "123-4X7",
                "123-4X8",
                "123-4X9",
                "123-456",
                "XXX-X9X"};
        String[] result = new String[]{
                "123-406",
                "123-416",
                "123-426",
                "123-436",
                "123-446",
                "123-466",
                "123-476",
                "123-486"
        };
        System.out.println(Arrays.toString(KRACK.phone(hope_number, exist_number)));
    }

    public static String[] phone(String hope_number, String[] exist_number) {
        hope_combination(hope_number, 0, new StringBuilder());

        for (String number : exist_number) {
            exist_combination(number, 0, new StringBuilder());
        }

        List<String> result = new ArrayList<>();
        for (String cur : hopeNumSet) {
            if (!existNumSet.contains(cur)) {
                result.add(cur);
            }
        }

        return result.toArray(new String[0]);
    }

    private static void hope_combination(String number, int idx, StringBuilder temp) {
        if (idx == number.length()) {
            hopeNumSet.add(temp.toString());
            return;
        }

        char c = number.charAt(idx);
        if (c == 'X') {
            for (int i = 0; i <= 9; i++) {
                temp.append(i);
                hope_combination(number, idx + 1, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        } else {
            temp.append(c);
            hope_combination(number, idx + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    private static void exist_combination(String number, int idx, StringBuilder temp) {
        if (idx == number.length()) {
            existNumSet.add(temp.toString());
            return;
        }

        char c = number.charAt(idx);
        if (c == 'X') {
            for (int i = 0; i <= 9; i++) {
                temp.append(i);
                exist_combination(number, idx + 1, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        } else {
            temp.append(c);
            exist_combination(number, idx + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
