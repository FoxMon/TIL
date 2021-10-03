package everyday.virus;

import java.util.Scanner;

public class Main {
    public static int[][] virus;
    public static int[][] temp;
    public static int maxScore = Integer.MIN_VALUE;
    public static int mapRow;
    public static int mapCol;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mapRow = scanner.nextInt();
        mapCol = scanner.nextInt();
        virus = new int[mapRow][mapCol];
        temp = new int[mapRow][mapCol];

        for(int i = 0; i < mapRow; i++) {
            for(int j = 0; j < mapCol; j++) {
                virus[i][j] = scanner.nextInt();
            }
        }

        dfs(0);
        System.out.println(maxScore);
    }

    public static int getResult() {
        int result = 0;

        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp[i].length; j++) {
                if(temp[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void goVirus(int row, int col) {
        for(int i = 0; i < 4; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if(tempRow >= 0 && tempRow < mapRow && tempCol >= 0 && tempCol < mapCol) {
                if(temp[tempRow][tempCol] == 0) {
                    temp[tempRow][tempCol] = 2;
                    goVirus(tempRow, tempCol);
                }
            }
        }
    }

    public static void dfs(int count) {
        if(count == 3) {
            for(int i = 0; i < mapRow; i++) {
                for(int j = 0; j < mapCol; j++) {
                    temp[i][j] = virus[i][j];
                }
            }

            for(int i = 0; i < mapRow; i++) {
                for(int j = 0; j < mapCol; j++) {
                    if(temp[i][j] == 2) {
                        goVirus(i, j);
                    }
                }
            }

            maxScore = Math.max(maxScore, getResult());
            return;
        }

        for(int i = 0; i < mapRow; i++) {
            for(int j = 0; j < mapCol; j++) {
                if(virus[i][j] == 0) {
                    virus[i][j] = 1;
                    count++;
                    dfs(count);
                    virus[i][j] = 0;
                    count--;
                }
            }
        }
    }
}
