package yelim.binarysearch;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Longest {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 크기
        int N = Integer.parseInt(br.readLine());

        // 수열 배열
        int[] arr = new int[N];
        // 각 수를 비교하기 위한 리스트
        ArrayList<Integer> lst = new ArrayList<>();
        // 입력 값보다 무조건 작은 0을 넣어 비교하게 한다.
        lst.add(0);

        String[] el = br.readLine().split(" ");
        for(int i=0;i < N;i++) {
            int val = arr[i] = Integer.parseInt(el[i]);

            // 리스트에 최근에 넣은 수와 비교했을 때, 크다면 리스트에 넣는다.
            if(val > lst.get(lst.size() - 1)) lst.add(val);
            else { // 리스트에 최근에 넣은 수와 비교했을 때, 작다면
                // 이분 탐색을 통해 리스트에서 val이 들어갈 자리는 찾는다.
                int l = 0;
                int r = lst.size() - 1;

                while(l < r) {
                    int mid = (l + r) / 2;
                    if(lst.get(mid) >= val) {
                        r = mid;
                    }else {
                        l = mid + 1;
                    }
                }
                lst.set(r, val);
            }
        }
        System.out.println(lst.size() - 1);
    }
}
// lowerbound를 사용하는 이유
// 예측할 수 없는 수들 중 더 작은 수가 나왔을 때 받아들일 수 있는 범위가 넓어진다.
// 즉, 가장 긴 증가하는 수열이 되기 위한 최적의 상태를 만들어나간다.
// 예를 들어, 10 20 18 19 30 이라고 생각해보자.
// array에 {10, 20} 이 있는 경우,
// 18의 lowerbound index는 1이 되고, 그 자리를 대체하면 array는 {10, 18}이 된다.
// 이렇게 되면 마지막에 20이 자리하는 경우보다, 18이 자리했을 때
// 뒤로 받아들일 수 있는 수들의 범위가 더 넓어지게 됨으로써 19를 다음으로 받아들일 수 있게 된다.