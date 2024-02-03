package yelim.solvedac.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet { // 추후 더 고칠 예정...
    static int R;
    static int C;
    static char[][] board;
    static boolean[][] check;
    static int[][] distance;
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Character> search = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세로 R칸, 가로 C칸 보드 (1 <= R, C <= 20)
        // 말이 움직이기 위해서는 현재 말이 놓여 있는 곳의 문자와 다른 문자가 있는 칸으로 이동할 수 있다.
        // 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
        // 말이 지나는 칸은 죄측 상단의 칸도 포함
        // 무조건 시작은 (1, 1)에서
        // 말이 최대 몇 칸을 지날 수 있는지?
        // leetcode 단어 찾기랑 비슷?

        String[] rc = br.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        board = new char[R+1][C+1];
        for(int r = 1;r <= R;r++) {
            char[] row = br.readLine().toCharArray();
            for(int c = 1;c <= C;c++) {
                board[r][c] = row[c - 1];
            }
        }

        for(char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }

        check = new boolean[R+1][C+1];
        distance = new int[R+1][C+1];

        search = new ArrayList<>();
        alphabet(1, 1, search);

        System.out.println(result);
        br.close();
    }

    // 백트래킹 -> 탐색을 할 동안 말이 있었던 자리의 문자를 담는 리스트 -> 이 리스트에 탐색한 좌표의 문자가 있다면 종료
    //      탐색한 좌표의 문자가 리스트에 없다면 넣고 계속 탐색
    //      하나의 백트래킹 탐색을 완료하면 다시 boolean 2차원 배열을 원상태로 되돌리기, search 리스트도 되돌리기 해야함
    static void alphabet(int r, int c, List<Character> search) {
        if(search.contains(board[r][c])) {
            result = Math.max(result, search.size());
            return;
        }

        search.add(board[r][c]);
        check[r][c] = true;

        for(int i = 0;i < 4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr > 0 && nr <= R && nc > 0 && nc <= C) {
                // Character 말고 string으로??
                if(!check[nr][nc]) {
                    alphabet(nr, nc, search);
                    check[nr][nc] = false;
//                    search.remove(board[nr][nc]);
                }
            }
        }
    }
}
