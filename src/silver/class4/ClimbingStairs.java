package silver.class4;

// DP : 점화식 찾기, 못 찾으면 끝나는 문제
// (1) 일단 한 번 적어볼까? -> O
// (2) 하지만 점화식을 구하지 못 했음
// (3) 원인
// - 정상에 올라가는 "가짓수"에 집착하여 1+1+2 or 1+2+1 or 2+1+1로 어떻게 표현하지?에 매몰됨
// - 따라서 가짓수를 "값"으로 생각하지 못함
// - 따라서 알맞은 자료구조(배열)를 생각하지 못함
// 결과적으로 점화식을 찾아내지 못함

class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[46];

        arr[1] = 1;
        arr[2] = 2;

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            for (int i = 3; i <= n; i ++) {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(2);
    }
}