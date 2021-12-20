package baekSimulation.baekSimulation01;

import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int startRow;
    public static int startCol;
    public static int direction;
    public static int count;
    public static int[] dy = { -1, 0, 1, 0 }; // north, south
    public static int[] dx = { 0, 1, 0, -1 }; // east, west
    public static int[][] map;

    public static void main(String[] args) { // n -> 0, e -> 1, s -> 2, w -> 3
        Scanner scanner = new Scanner(System.in); // back -> 3 + 2 % 4 -> 1, or 2 + 2 % 4 -> 0
        row = scanner.nextInt();
        col = scanner.nextInt();
        startRow = scanner.nextInt();
        startCol = scanner.nextInt();
        direction = scanner.nextInt();
        map = new int[row][col];
        count = 1;

        for(int i = 0; i < row; i++) { // vacant -> 0, wall -> 1
            for(int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        clean(startRow, startCol, direction);
        System.out.println(count);
    }

    public static void clean(int tempRow, int tempCol, int tempDirection) {
        map[tempRow][tempCol] = -1;

        for(int i = 0; i < 4; i++) {
            tempDirection = (tempDirection + 3) % 4;
            int currentRow = tempRow + dy[tempDirection];
            int currentCol = tempCol + dx[tempDirection];

            if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                if(map[currentRow][currentCol] == 0) {
                    count++;
                    clean(currentRow, currentCol, tempDirection);
                    return; // back
                }
            }
        }

        int currentDirection = (tempDirection + 2) % 4;
        int backRow = tempRow + dy[currentDirection];
        int backCol = tempCol + dx[currentDirection];

        if(backRow >= 0 && backCol >= 0 && backRow < row && backCol < col) {
            if(map[backRow][backCol] != 1) {
                clean(backRow, backCol, tempDirection);
            }
        }
    }
}
