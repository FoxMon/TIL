package baekSimulation.baekSimulation01re;

import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int direction;
    public static int count = 1;
    public static int[] dy = { -1, 0, 1, 0 }; // 북 동 남 서
    public static int[] dx = { 0, 1, 0, -1 };
    public static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new int[row][col];
        int robotRow = scanner.nextInt();
        int robotCol = scanner.nextInt();
        direction = scanner.nextInt();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        clean(robotRow, robotCol, direction);
        System.out.println(count);
    }

    public static void clean(int currentRow, int currentCol, int currentDirection) {
        map[currentRow][currentCol] = -1;

        for(int i = 0; i < 4; i++) {
            currentDirection = (currentDirection + 3) % 4;
            int tempRow = currentRow + dy[currentDirection];
            int tempCol = currentCol + dx[currentDirection];

            if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) {
                if(map[tempRow][tempCol] == 0) {
                    count++;
                    clean(tempRow, tempCol, currentDirection);
                    return; // back
                }
            }
        }

        int backDirection = (currentDirection + 2) % 4;
        int backRow = currentRow + dy[backDirection];
        int backCol = currentCol + dx[backDirection];

        if(backRow >= 0 && backCol >= 0 && backRow < row && backCol < col) {
            if(map[backRow][backCol] != 1) {
                clean(backRow, backCol, currentDirection);
            }
        }
    }
}
