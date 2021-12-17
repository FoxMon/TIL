package baekSearch.search02;

import java.util.Scanner;

public class Main { // dfs로 가능함.
    public static boolean[][] visited;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int row;
    public static int col;
    public static int cabbageCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int k = 0; k < testCase; k++) {
            int count = 0;
            row = scanner.nextInt();
            col = scanner.nextInt();
            cabbageCount = scanner.nextInt();
            map = new int[row][col];
            visited = new boolean[row][col];

            for (int i = 0; i < cabbageCount; i++) {
                int y = scanner.nextInt();
                int x = scanner.nextInt();
                map[y][x] = 1;
            }

            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
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
        map[tempRow][tempCol] = 0;

        for(int i = 0; i < 4; i++) {
            int cabbageRow = tempRow + dy[i];
            int cabbageCol = tempCol + dx[i];

            if(cabbageCol >= 0 && cabbageRow >= 0 && cabbageCol < col && cabbageRow < row) {
                if(map[cabbageRow][cabbageCol] == 1 && !visited[cabbageRow][cabbageCol]) {
                    find(cabbageRow, cabbageCol);
                }
            }
        }
    }
}