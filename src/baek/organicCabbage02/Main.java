package baek.organicCabbage02;

import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int cabbage;
    public static int areaCOunt;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            row = scanner.nextInt();
            col = scanner.nextInt();
            cabbage = scanner.nextInt();
            map = new int[row][col];
            visited = new boolean[row][col];

            for(int j = 0; j < cabbage; j++) {
                int cabbageRow = scanner.nextInt();
                int cabbageCol = scanner.nextInt();
                map[cabbageRow][cabbageCol] = 1;
            }

            areaCOunt = 0;

            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    if(map[j][k] == 1 && !visited[j][k]) {
                        findCabbage(j, k);
                        areaCOunt++;
                    }
                }
            }

            System.out.println(areaCOunt);
        }
    }

    public static void findCabbage(int startRow, int startCol) {
        map[startRow][startCol] = 0;
        visited[startRow][startCol] = true;

        for(int i = 0; i < 4; i++) {
            int tempRow = startRow + dy[i];
            int tempCol = startCol + dx[i];

            if(tempRow >= 0 && tempRow < row && tempCol >= 0 && tempCol < col) {
                if(!visited[tempRow][tempCol] && map[tempRow][tempCol] == 1) {
                    findCabbage(tempRow, tempCol);
                }
            }
        }
    }
}
