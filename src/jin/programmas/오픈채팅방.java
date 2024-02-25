package jin.programmas;

import java.util.*;

// 2019 KAKAO BLIND RECRUITMENT 오픈채팅방

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        Map<String, String> commands = new HashMap<>();
        commands.put("Enter", "들어왔습니다.");
        commands.put("Leave", "나갔습니다.");
        int len = 0;

        for (String rec : record) {
            String[] strs = rec.split(" ");
            String s0 = strs[0];
            String s1 = strs[1];

            if (commands.containsKey(s0)) {
                len++;
            }

            if (Objects.equals(s0, "Enter") || Objects.equals(s0, "Change")) {
                users.put(s1, strs[2]);
            }
        }

        String[] answer = new String[len];

        int idx = 0;
        for (String rec : record) {
            String[] strs = rec.split(" ");
            String s0 = strs[0];
            String s1 = strs[1];

            StringBuilder sb = new StringBuilder();

            if (commands.containsKey(s0)) {
                String info = commands.get(s0);
                if (users.containsKey(s1)) {
                    sb.append(users.get(s1)).append("님이").append(" ").append(info);
                    answer[idx++] = sb.toString();
                }
            }
        }

        return answer;
    }
}
