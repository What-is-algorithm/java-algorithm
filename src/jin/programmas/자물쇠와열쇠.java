package jin.programmas;

import java.util.*;

public class 자물쇠와열쇠 {
    // roateKey()
    // isCorrect()
    // for i in range(4)
    // 열쇠회전
    // 자물쇠 맞춰보기 if(check)-> return true
    // else 열쇠 이전 상태로 원복
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        int[][] newLock = new int[n * 3][n * 3];
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                newLock[i][j] = lock[i - n][j - n];
            }
        }

        // for (int[] a : newLock) {
        //     System.out.println(Arrays.toString(a));
        // }

        for (int d = 0; d < 4; d++) {
            key = rotate90(key);
            for (int y = 0; y < n * 2; y++) {
                for (int x = 0; x < n * 2; x++) {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[y + i][x + j] += key[i][j];
                        }
                    }

                    if (isCorrect(newLock, n)) return true;

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[y + i][x + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    private int[][] rotate90(int[][] key) {
        int m = key.length;
        int[][] rotateKey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotateKey[i][j] = key[m - 1 - j][i];
            }
        }

        return rotateKey;
    }

    private boolean isCorrect(int[][] lock, int n) {
        for (int i = n; i < n * 2; i++) {
            for (int j = n; j < n * 2; j++) {
                if (lock[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
