package baekSearch.search06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int count;
    public static int result = 0;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        row = scanner.nextInt();
        col = scanner.nextInt();
        count = scanner.nextInt();
        map = new int[row][col];

        for(int i = 0; i < count; i++) {
            int firstX = scanner.nextInt();
            int firstY = scanner.nextInt();
            int lastX = scanner.nextInt();
            int lastY = scanner.nextInt();

            for(int j = firstY; j < lastY; j++) {
                for(int k = firstX; k < lastX; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 0) {
                    result = 0;
                    find(i, j);
                    list.add(result);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);

        for(int target : list) {
            System.out.print(target + " ");
        }
    }

    public static void find(int tempRow, int tempCol) {
        map[tempRow][tempCol] = 1;
        result++;

        for(int i = 0; i < 4; i++) {
            int currentRow = tempRow + dy[i];
            int currentCol = tempCol + dx[i];

            if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                if(map[currentRow][currentCol] == 0) {
                    find(currentRow, currentCol);
                }
            }
        }
    }
}
