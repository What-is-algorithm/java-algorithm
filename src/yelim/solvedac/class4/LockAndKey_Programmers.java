package yelim.solvedac.class4;

public class LockAndKey_Programmers {
    public static void main(String[] args) {
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };

        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        System.out.println(openDoor(key, lock));
    }

    public static boolean openDoor(int[][] key, int[][] lock) {
        // 배열 확장 -> 자물쇠의 길이 + (키의길이*2) - 2 크기의 배열 map[][]
        // 키의 길이
        int m = key.length;
        // 자물쇠의 길이
        int n = lock.length;

        int len = n + (m * 2) - 2;
        int[][] map = new int[len][len];

        // map에 lock 배열의 값을 위치에 맞게 입력
        for(int i=m - 1;i < m + n - 1;i++) {
            for(int j=m - 1;j < m + n - 1;j++) {
                map[i][j] = lock[i - (m - 1)][j - (m - 1)];
            }
        }

        for(int i=0;i < 4;i++) {
            if(check(map, key, n)){ // 키가 자물쇠에 맞는지
                return true;
            }
            rotate(key); // 시계방향 90도 회전시키면서 4가지 모양 다 확인
        }

        return false;
    }

    public static boolean check(int[][] map, int[][] key, int lockLen){
        int keyLen = key.length; // 키의 길이
        int mapLen = map.length; // 확장된 자물쇠의 길이
        for(int i=0;i < mapLen -keyLen + 1;i++) {
            for(int j=0;j < mapLen - keyLen + 1;j++) {

                // map에 key를 더하기
                for(int k=0;k < keyLen;k++) {
                    for(int l=0;l < keyLen;l++) {
                        map[i + k][j + l] += key[k][l];
                    }
                }

                // 자물쇠 부분이 전부 1이 됐는지 확인 -> 맞는 키인지
                boolean flag = true;
                for(int k=keyLen - 1;k < keyLen + lockLen - 1;k++){
                    for(int l=keyLen - 1;l < keyLen + lockLen - 1;l++){
                        if(map[k][l] != 1){ // 1이 아니면 홈이 안 맞지 않는 것
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                }

                if(flag) return true;   // 전부 1이였다면(키가 맞다면) true

                // map을 원상 복귀 -> map에서 key를 빼기;
                for(int k=0;k < keyLen;k++){
                    for(int l=0;l < keyLen;l++){
                        map[i + k][j + l] -= key[k][l];
                    }
                }

            }
        }

        return false;
    }

    public static void rotate(int[][] key){
        int len = key.length;
        int[][] temp = new int[len][len];

        for(int i=0;i < len;i++) {
            for(int j=0;j < len;j++) {
                temp[i][j] = key[len - j- 1][i];
            }
        }

        for(int i=0;i < len;i++) {
            for(int j=0;j < len;j++) {
                key[i][j] = temp[i][j];
            }
        }

    }
}
// https://code-lab1.tistory.com/152