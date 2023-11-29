package yelim.greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Atm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] time = br.readLine().split(" ");

        // 각 사람의 인출 시간을 해시맵에 저장
        // 키 : 각 사람, 값 : 인출 시간
        for(int i=0;i < N;i++) {
            map.put(i+1, Integer.parseInt(time[i]));
        }

        // 각 사람의 인출 시간을 오름차순으로 정렬
        // 인출 시간이 짧은 사람부터 처리하는 것이 총 시간이 짧으므로
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));

        int sum = 0;
        int total = 0;

        for(int k : keySet) {
            // 이전 사람까지 걸린 시간에서 더하기
            sum += map.get(k);
            // 각 사람의 기다리고 인출을 끝난 시간을 총 시간에 더하기
            total += sum;
        }

        System.out.println(total);
    }
}
