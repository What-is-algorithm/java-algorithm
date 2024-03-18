package yelim.solvedac.class4;

public class StringCompression_Programmers { // 스스로 풀어폰 코드는 계속 오류가 나서 정답 코드를 공부하였습니다...
    public static void main(String[] args) {
        // "ababcdcdababcdcd" -> "2ababcdcd" : 길이 9
        String s = "aabbaccc"; // 1 <= s의 길이 <= 1000
        System.out.println(solution(s));
    }

    // 문자열에서 같은 문자가 연속해서 나타난 경우, 그 문자의 개수와 반복되는 문자로 표현
    // aabbaccc -> 2a2ba2c : 길이 7
    // 문자열에서 문자를 몇 개 단위로 압축하느냐에 따라 압축한 문자열의 길이가 달라짐 -> 최소 압축 문자열 길이 출력
    // 문자열은 제일 앞에서 정해진 길이 만큼 잘라야 한다
    // 단위 문자가 길수록 문자열 압축이 더 짧게 되는가
    public static int solution(String s) {
        int answer = s.length(); // 압축된 문자열 최소 길이
        int count = 1;

        for(int i = 1; i < (s.length() / 2); i++) {
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i); // 기준 문자

            for(int j=i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length()); // 인덱스는 주어진 문자열의 길이를 넘지 못하게 한다.
                String compare = s.substring(j, endIdx); // 기준 문자와 비교할 문자

                if(base.equals(compare)) { // 기준 문자와 비교
                    count++;
                }else {
                    if(count >= 2) { // 기준 문자와 같지 않다면 이전에 세고 있던 문자 개수 반영
                        result.append(count);
                    }
                    result.append(base);
                    base = compare; // 다음 기준 문자로 갱신
                    count = 1; // 새로 기준 문자가 갱신되었으므로 초기화
                }
            }
            result.append(base);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
// https://velog.io/@ckr3453/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%95%95%EC%B6%95-Java