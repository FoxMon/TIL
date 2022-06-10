package programmers.level3.lockAndKey;

public class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int lockSize = lock.length - 1;

        for(int i = 0; i < 4; i++) {
            key = turnRight(key);
            int[][] temp = move(key, lockSize);

            for(int j = 0; j < temp.length - lockSize; j++) {
                for(int k = 0; k < temp.length - lockSize; k++) {
                    if(check(temp, lock, j, k)) {
                        answer = true;
                    }
                }
            }
        }

        return answer;
    }

    public boolean check(int[][] key, int[][] lock, int row, int col) {
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if(lock[i][j] + key[i + row][j + col] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public int[][] turnRight(int[][] key) {
        int[][] temp = new int[key.length][key[0].length];

        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key[i].length; j++) {
                temp[i][j] = key[key[i].length - 1 - j][i];
            }
        }

        return temp;
    }

    public int[][] move(int[][] key, int lockSize) {
        int[][] temp = new int[key.length + (lockSize * 2)][key[0].length + (lockSize * 2)];

        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key[i].length; j++) {
                temp[i + lockSize][j + lockSize] = key[i][j];
            }
        }

        return temp;
    }
}
