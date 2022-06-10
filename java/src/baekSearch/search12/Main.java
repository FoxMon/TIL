package baekSearch.search12;

import java.util.Scanner;

public class Main {
    public static int row;
    public static int col;
    public static int count;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static boolean[] visited;
    public static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        count = 0;
        map = new int[row][col];
        visited = new boolean[26];

        for(int i = 0; i < row; i++) {
            String word = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = word.charAt(j) - 'A';
            }
        }

        find(0, 0, 0);
        System.out.println(count);
    }

    public static void find(int tempRow, int tempCol, int result) {
        if(visited[map[tempRow][tempCol]]) {
            count = Math.max(count, result);
            return;
        } else {
            visited[map[tempRow][tempCol]] = true;

            for(int i = 0; i < 4; i++) {
                int currentRow = tempRow + dy[i];
                int currentCol = tempCol + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                    find(currentRow, currentCol, result + 1);
                }
            }

            visited[map[tempRow][tempCol]] = false;
        }
    }
}
