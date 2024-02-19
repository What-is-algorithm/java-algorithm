package jin.programmas;


// 2019 KAKAO BLIND RECRUITMENT 블록게임
public class 블록게임 {
    static final int BLACK = 201;
    static int n;
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;
        boolean hasDeleted = true;

        while (hasDeleted) {
            hasDeleted = false;

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (board[i][j] == 0 || board[i][j] == BLACK) {
                        board[i][j] = BLACK;
                    } else {
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i <= n - 2 && j <= n - 3) {
                        boolean isDeleted = tryDelete(board, i, j, 2, 3);

                        if (isDeleted) {
                            answer++;
                            hasDeleted = true;
                        }
                    }

                    if (!hasDeleted && i <= n - 3 && j <= n - 2) {
                        boolean isDeleted = tryDelete(board, i, j, 3, 2);

                        if (isDeleted) {
                            answer++;
                            hasDeleted = true;
                        }
                    }
                }
            }
        }

        return answer;
    }

    private boolean tryDelete(int[][] board, int y, int x, int yl, int xl) {
        int blackCnt = 0, blockCnt = 0, color = -1;

        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                if (board[y + i][x + j] == BLACK) {
                    blackCnt++;
                } else if (board[y + i][x + j] > 0) {
                    if (color == -1 || board[y + i][x + j] == color) {
                        blockCnt++;
                        color = board[y + i][x + j];
                    }
                }
            }
        }

        if (blackCnt == 2 && blockCnt == 4) {
            for (int i = 0; i < yl; i++) {
                for (int j = 0; j < xl; j++) {
                    board[y + i][x + j] = 0;
                }
            }

            return true;
        }

        return false;
    }
}
