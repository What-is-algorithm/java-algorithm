package jin.programmas;

// 2020 KAKAO BLIND RECRUITER 문자열 압축

public class 문자열압축 {
    public int solution(String s) {
        int n = s.length();

        if (n == 1) return 1;

        int answer = 1001;

        for (int i = 1; i < n / 2 + 1; i++) {
            StringBuilder compressed = new StringBuilder();
            int cnt = 1;
            String temp = s.substring(0, i);

            for (int j = i; j < n + 1; j += i) {
                String next = i + j > n ? s.substring(j) : s.substring(j, i + j);

                if (temp.equals(next)) cnt++;
                else {
                    compressed.append(cnt > 1 ? cnt : "").append(temp);
                    temp = next;
                    cnt = 1;
                }
            }

            compressed.append(cnt > 1 ? cnt : "").append(temp);
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
