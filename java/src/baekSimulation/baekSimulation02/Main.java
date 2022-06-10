package baekSimulation.baekSimulation02;

import java.util.Scanner;

public class Main {
    public static int[] dy = { 0, 1, 0, -1 };
    public static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int count = scanner.nextInt();
        int rotateGroup = Math.min(row, col) / 2;
        int[][] arr = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < rotateGroup; j++) {
                int tempRow = j;
                int tempCol = j;
                int prev = arr[tempRow][tempCol];
                int direction = 0; // direction

                while(direction < 4) {
                    int currentRow = tempRow + dy[direction]; // top, bottom
                    int currentCol = tempCol + dx[direction]; // right, left

                    if(currentRow >= j && currentCol >= j && currentRow < row - j && currentCol < col - j) { // group 내에 있냐?
                        arr[tempRow][tempCol] = arr[currentRow][currentCol];
                        tempRow = currentRow;
                        tempCol = currentCol;
                    } else {
                        direction++;
                    }
                }

                arr[j + 1][j] = prev;
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
