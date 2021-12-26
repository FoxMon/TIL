package baekSearch.search25;

import java.util.Scanner;

public class Main { // re
    public static int row;
    public static int col;
    public static int count = 0;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new int[row][col];
        dp = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(find(0, 0));
    }

    public static int find(int tempRow, int tempCol) {
        if(tempRow == row - 1 && tempCol == col - 1) {
            return 1;
        }

        if(dp[tempRow][tempCol] != -1) {
            return dp[tempRow][tempCol];
        }

        dp[tempRow][tempCol] = 0;

        for(int i = 0; i < 4; i++) {
            int currentRow = tempRow + dy[i];
            int currentCol = tempCol + dx[i];

            if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                if(map[currentRow][currentCol] < map[tempRow][tempCol]) {
                    dp[tempRow][tempCol] += find(currentRow, currentCol);
                }
            }
        }

        return dp[tempRow][tempCol];
    }
}
