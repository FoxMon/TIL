package everyday.eatIce02;

import java.util.Scanner;

public class Main {
    public static int rowSize;
    public static int colSize;
    public static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowSize = scanner.nextInt();
        colSize = scanner.nextInt();
        map = new int[rowSize][colSize];

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int count = 0;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(dfs(i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean dfs(int row, int col) {
        if(row < 0 || col < 0 || row > rowSize - 1 || col > colSize - 1) {
            return false;
        }

        if(map[row][col] == 0) {
            map[row][col] = 1;
            dfs(row + 1, col);
            dfs(row - 1, col);
            dfs(row, col + 1);
            dfs(row, col - 1);

            return true;
        }

        return false;
    }
}
