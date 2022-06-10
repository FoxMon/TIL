package baekSearch.search02re;

import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int cabbageCount;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            col = scanner.nextInt();
            row = scanner.nextInt();
            cabbageCount = scanner.nextInt();
            map = new int[row][col];
            visited = new boolean[row][col];
            int count = 0;

            for(int j = 0; j < cabbageCount; j++) {
                int cabbageCol = scanner.nextInt();
                int cabbageRow = scanner.nextInt();
                map[cabbageRow][cabbageCol] = 1;
            }

            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    if(map[j][k] == 1 && !visited[j][k]) {
                        findCabbage(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void findCabbage(int tempRow, int tempCol) {
        visited[tempRow][tempCol] = true;
        map[tempRow][tempCol] = 0;

        for(int i = 0; i < 4; i++) {
            int currentRow = tempRow + dy[i];
            int currentCol = tempCol + dx[i];

            if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                if(!visited[currentRow][currentCol] && map[currentRow][currentCol] == 1) {
                    findCabbage(currentRow, currentCol);
                }
            }
        }
    }
}
