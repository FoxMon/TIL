package everyday.virus02;

import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int max = Integer.MIN_VALUE;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[][] virus;
    public static int[][] temp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        virus = new int[row][col];
        temp = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                virus[i][j] = scanner.nextInt();
            }
        }

        dfs(0);
        System.out.println(max);
    }

    public static int getResult() {
        int result = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(temp[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void goVirus(int mapRow, int mapCol) {
        for(int i = 0; i < 4; i++) {
            int tempRow = mapRow + dy[i];
            int tempCol = mapCol + dx[i];

            if(tempRow >= 0 && tempRow < row && tempCol >= 0 && tempCol < col) {
                if(temp[tempRow][tempCol] == 0) {
                    temp[tempRow][tempCol] = 2;
                    goVirus(tempRow, tempCol);
                }
            }
        }
    }

    public static void dfs(int count) {
        if(count == 3) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    temp[i][j] = virus[i][j];
                }
            }

            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(temp[i][j] == 2) {
                        goVirus(i, j);
                    }
                }
            }

            max = Math.max(max, getResult());
            return;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(virus[i][j] == 0) {
                    virus[i][j] = 1;
                    count++;
                    dfs(count);
                    count--;
                    virus[i][j] = 0;
                }
            }
        }
    }
}
