package everyday.lockAndKey;

public class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int lockSize = lock.length - 1;

        for(int i = 0; i < 4; i++) {
            key = turnRight(key);
            int[][] reSize = move(key, lockSize);

            for(int j = 0; j < reSize.length - lockSize; j++) { // 핵심
                for(int k = 0; k < reSize.length - lockSize; k++) {
                    if(check(lock, reSize, j, k)) {
                        answer = true;
                    }
                }
            }
        }

        return answer;
    }

    private int[][] turnRight(int[][] key) {
        int[][] temp = new int[key.length][key.length];

        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                temp[i][j] = key[key.length - j - 1][i];
            }
        }

        return temp;
    }

    private boolean check(int[][] lock, int[][] key, int row, int col) {
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if(lock[i][j] + key[row + i][col + j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] move(int[][] key, int lockSize) { // 핵심
        int[][] temp = new int[key.length + (lockSize) * 2][key.length + (lockSize) * 2];

        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                temp[lockSize + i][lockSize + j] = key[i][j];
            }
        }

        return temp;
    }
}
