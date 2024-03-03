package yelim.solvedac.class4;

import java.util.HashMap;

public class OpenChatting_Programmers {
    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        System.out.println(solution(record));
    }
    // 모든 유저는 "Enter [유저 아이디] [닉네임]"에서 유저 아이디로 구분한다.
    // Enter, Leave, Change
    // 유저 아이디와 닉네임의 길이는 1 이상 10 이하
    // 중복 닉네임 허용하기 때문에 나갔다가 이름을 바꾸고 다시 들어왔을 때가 닉네임 갱신이 결과에 있어야 한다.
    // 최종적으로 방을 개설한 사람이 보게 되는 메시지 출력

    // 특정 아이디가 마지막으로 사용한 닉네임을 먼저 파악하고 메시지를 보여줄 때 아이디를 닉네임으로 바꾸기
    public static String[] solution(String[] record) {
        // 닉네임 변경 사항을 저장할 HashMap
        // 키는 아이디이고 값은 닉네임으로
        HashMap<String, String> idMap = new HashMap<>();
        // 닉네임을 바꾸는 것은 메세지로 나오지 않음 -> 출력할 메세지 길이에서 제외
        int count = 0;

        for(int i=0;i < record.length;i++){
            String[] input = record[i].split(" ");

            if(input[0].equals("Leave")){ // 나가는 경우
                continue; // 닉네임 변경이 없으므로
            } else if(input[0].equals("Enter")){ // 들어오는 경우
                idMap.put(input[1], input[2]);
            } else { // 닉네임을 변경하는 경우
                idMap.put(input[1], input[2]);
                count++;
            }
        }
        String[] answer = new String[record.length - count];
        int idx = 0;

        for(int i = 0; i < record.length; i++){
            String[] change = record[i].split(" ");
            String nickname = idMap.get(change[1]);

            if(change[0].equals("Enter")){ // 들어오는 경우
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if(change[0].equals("Leave")){ // 나가는 경우
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
// https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%98%A4%ED%94%88%EC%B1%84%ED%8C%85%EB%B0%A9-Java
