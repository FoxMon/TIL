package baek.sheep;

import java.util.Scanner;

public class Main {
    public static int mapRow;
    public static int mapCol;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static char[][] field;
    public static boolean[][] visited;
    public static int sheepCount;
    public static int wolfCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mapRow = scanner.nextInt();
        mapCol = scanner.nextInt();
        field = new char[mapRow][mapCol];
        visited = new boolean[mapRow][mapCol];

        for(int i = 0; i < mapRow; i++) { // . # o ( sheep ) v ( wolf )
            String temp = scanner.next();

            for(int j = 0; j < mapCol; j++) {
                field[i][j] = temp.charAt(j);
            }
        }

        int sheep = 0;
        int wolf = 0;

        for(int i = 0; i < mapRow; i++) {
            for(int j = 0; j < mapCol; j++) {
                if(!visited[i][j] && (field[i][j] != '#')) {
                    find(i, j);

                    if(sheepCount > wolfCount) {
                        sheep += sheepCount;
                    } else {
                        wolf += wolfCount;
                    }

                    sheepCount = 0;
                    wolfCount = 0;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void find(int row, int col) {
        visited[row][col] = true;

        if(field[row][col] == 'o') {
            sheepCount++;
        } else if(field[row][col] == 'v') {
            wolfCount++;
        }

        for(int i = 0; i < 4; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if(tempRow >= 0 && tempRow < mapRow && tempCol >= 0 && tempCol < mapCol) {
                if(!visited[tempRow][tempCol] && field[tempRow][tempCol] != '#') {
                    find(tempRow, tempCol);
                }
            }
        }
    }
}
