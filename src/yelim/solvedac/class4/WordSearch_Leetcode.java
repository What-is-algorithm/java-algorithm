package yelim.solvedac.class4;

public class WordSearch_Leetcode {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";

        System.out.println(exist(board, word));
    }
    static boolean result = false;

    // 상하좌우
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static boolean[][] check;
    static StringBuilder makeWord;

    // m == board.length
    // n = board[i].length
    // 1 <= m, n <= 6
    // 1 <= word.length <= 15

    // 2차원 배열에서 어디서 시작하는가를 exist 함수에서
    // 시작한 곳에서 word를 완성할 수 있는지 탐색하는 wordSearch 함수
    public static boolean exist(char[][] board, String word) {
        for(int i=0;i < board.length;i++) {
            for(int j=0;j < board[i].length;j++) {
                makeWord = new StringBuilder();
                check = new boolean[board.length][board[i].length];
                wordSearch(board, word, i, j, 0, makeWord);
                if(result) return result;
            }
        }

        return result;
    }

    // 탐색할 2차원 배열 board, 만들어야 할 단어 word, 탐색 배열의 행 i, 탐색 배열의 열 j, 탐색된 문자 길이 len, 탐색한 문자가 맞다면 누적할 makeWord
    static void wordSearch(char[][] board, String word, int i, int j, int len, StringBuilder makeWord) {
        if(word.equals(makeWord.toString())) {
            result = true;
            return;
        }else if(len < word.length()) { // [0, S], [1, E], [2, E] (  < 3)
            String search = word.substring(len, len+1);
            if(!search.equals(String.valueOf(board[i][j]))) {
                return;
            }else {
                check[i][j] = true;
                makeWord.append(search);
                for(int k =0;k < 4;k++) {
                    int ci = di[k] + i;
                    int cj = dj[k] + j;

                    if(ci >= 0 && ci < board.length && cj >= 0 && cj < board[i].length) {
                        if(!check[ci][cj]) {
                            wordSearch(board, word, ci, cj, len + 1, makeWord);
                        }
                    }
                }
            }
        }
    }
}
