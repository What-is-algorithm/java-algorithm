package jin.leetcode;

import java.util.*;

// 39. WordSearch
public class WordSearch_39 {
    // 첫글자가 같다면 그 글자 기준으로 탐색 시작
    // 탐색은 dfs
    // 그래프 범위 벗어나면 탐색 종료
    // 다음 알파벳이 다르면 종료
    // 방문한 적이 있으면 종료
    // 위의 조건이 모두 통과되면 위치 방문 = true + 4방향 탐색
    // 재귀가 끝날 때는 방문한 곳 = false
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && searchWord(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, boolean[][] visited, int y, int x, int cnt) {
        if (cnt == word.length()) return true;

        if (x < 0 || y < 0 || y >= board.length || x >= board[0].length) return false;
        if (board[y][x] != word.charAt(cnt) || visited[y][x]) return false;

        visited[y][x] = true;
        if (searchWord(board, word, visited, y + 1, x, cnt + 1) ||
                searchWord(board, word, visited, y, x + 1, cnt + 1) ||
                searchWord(board, word, visited, y - 1, x, cnt + 1) ||
                searchWord(board, word, visited, y, x - 1, cnt + 1)
        ) {
            return true;
        }

        visited[y][x] = false;
        return false;
    }
}
