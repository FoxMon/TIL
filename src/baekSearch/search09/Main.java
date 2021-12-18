package baekSearch.search09;

import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int count;
    public static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
    public static int[] dx = { 0, 0, -1, 1, -1, 1, 1, -1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            col = scanner.nextInt();
            row = scanner.nextInt();

            if(row == 0 && col == 0) {
                System.exit(0);
            }

            count = 0;
            map = new int[row][col];
            visited = new boolean[row][col];

            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        find(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void find(int tempRow, int tempCol) {
        visited[tempRow][tempCol] = true;

        for(int i = 0; i < 8; i++) {
            int currentRow = tempRow + dy[i];
            int currentCol = tempCol + dx[i];

            if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                if(!visited[currentRow][currentCol] && map[currentRow][currentCol] == 1) {
                    find(currentRow, currentCol);
                }
            }
        }
    }
}
