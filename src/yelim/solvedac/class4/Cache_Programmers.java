package yelim.solvedac.class4;

import java.util.ArrayList;

public class Cache_Programmers {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize,cities));
    }

    // 캐시 크기에 따른 실행 시간 측정
    // 0 <= cacheSize<= 30
    // cities 배열 크기 최대 100,000 (도시 이름 최대 20자, 대소문자 구분 X)
    // 캐시 교체 알고리즘은 LRU(Least Recent Used) - cache hit이라면 실행 시간 1이 걸리고, cache miss이라면 실행 시간이 5 걸린다.
    //      > 가장 오랫동안 참조되지 않은 페이지를 교체하는 방식
    //      > 가장 오랫동안 참조되지 않은 페이지를 찾아서 없애는 과정 필요
    //          >> 페이지를 참조할 때마다 연결 리스트 맨 앞에 페이지 번호를 추가한다.
    //          >> 맨 뒤에 있는 페이지 번호가 가장 오랫동안 참조되지 않은 페이지 번호가 된다.
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        ArrayList<String> lst = new ArrayList<>();
        lst.add(cities[0].toLowerCase());
        answer += 5;

        for(int i=1;i < cities.length;i++) {
            String cityName = cities[i].toLowerCase();
            // 리스트에 도시 이름이 있는지 확인
            //      -> 없다면 캐시 크기를 확인하여 오래 있던 도시는 빼고 최근으로 넣기
            //      -> 있다면 리스트 안에 있는 도시 이름을 지우고 최근으로 넣기
            if(lst.contains(cityName)) { // cache hit
                lst.remove(cityName);
                answer += 1;
            }else { // cache miss
                if(cacheSize == lst.size()) {
                    lst.remove(0);
                }
                answer += 5;
            }
            lst.add(cityName);

        }
        return answer;
    }
}
