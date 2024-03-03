package yelim.solvedac.class4;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lie {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 진실을 아는 사람들이 주어질 때, 이 사람들과 같은 파티에 갔던 사람들에게 들키지 않고
        // 얼마나 많은 파티에 가서 거짓말을 할 수 있는지
        String[] nm = br.readLine().split(" ");
        // 사람 수 <= 50
        int N = Integer.parseInt(nm[0]);
        // 파티 수 <= 50
        int M = Integer.parseInt(nm[1]);

        // 진실을 안다면 true로 표시하는 배열
        boolean[] knowPeople = new boolean[N+1];
        // 연결 정보
        ArrayList<Integer>[] arr = new ArrayList[M+1];
        for(int i=1;i<=M;i++){
            arr[i] = new ArrayList<>();
        }

        // 진실을 아는 사람들
        String[] knowInput = br.readLine().split(" ");
        int knowNum = Integer.parseInt(knowInput[0]); // 진실을 아는 사람들 수

        // 진실을 아는 사람이 없다면 파티 수를 출력하기
        if(knowNum == 0) {
            System.out.println(M);
            return;
        }

        for(int i=1;i <= N;i++) { // 진실을 아는 사람들을 표시
            knowPeople[Integer.parseInt(knowInput[i])] = true;
        }

        // 각 노드의 루트 초기화
        parent = new int[N + 1];
        for(int i=1;i <= N;i++){
            parent[i] = i;
        }

        // 2 1 2 -> 이 파티는 2명이 오고 1번, 2번이 온다.
        // 1 3 -> 이 파티는 1명이 오고 3번이 온다.
        // 3 2 3 4 -> 이 파티는 3명이 오고 2번, 3번, 4번이 온다.
        for(int i=1;i <= M;i++){
            knowInput = br.readLine().split(" ");
            int partyNum = Integer.parseInt(knowInput[0]); // 파티 인원

            if(partyNum <= 1){
                arr[i].add(Integer.parseInt(knowInput[1]));
                continue;
            }

            for(int j = 1;j < partyNum;j++){
                int a = Integer.parseInt(knowInput[j]);
                int b = Integer.parseInt(knowInput[j + 1]);

                if(find(a) != find(b)){ // 같은 파티에서 만나므로
                    union(a,b); // 같은 부모를 가지도록 합쳐줌
                }

                arr[i].add(a);
                arr[i].add(b);
            }
        }

        boolean[] check = new boolean[N + 1];
        for(int i=1;i <= N;i++){
            if(knowPeople[i] && !check[i]) { // 진실을 알고 있는 사람이라면
                int parent = find(i); // 루트 노드를 찾고
                for(int j=1;j <= N;j++){
                    if(find(j) == parent) { // 그 루트 노드와 같은 루트 노드라면
                        check[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for(int i=1;i <= M;i++) {
            boolean flag = false;
            for(int person : arr[i]) {
                if(knowPeople[person]) { // 진실을 아는 사람이 있으므로
                    flag = true; // 이 파티는 갈 수 없다.
                    break;
                }
            }

            if(!flag) result++; // 진실을 아는 사람이 없으므로
        }

        System.out.println(result);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b){
        int parentB = find(b);
        parent[parentB] = a;
    }
}
// https://red-mimmu.tistory.com/94