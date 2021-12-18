package baekSearch.search07;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String[][] map;
    public static String[][] copy;
    public static boolean[][] visited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int size;
    public static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>();
        size = scanner.nextInt();
        map = new String[size][size];
        copy = new String[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++) {
            String temp = scanner.next();
            for(int j = 0; j < size; j++) {
                map[i][j] = temp.charAt(j) + "";
            }
        }

        for(int k = 0; k < 2; k++) { // 0 -> false, 1 -> true
            visited = new boolean[size][size];
            count = 0;
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(!visited[i][j]) {
                        findRGB(i, j, map[i][j]);
                        count++;
                    }

                    if(map[i][j].equals("G")) {
                        map[i][j] = "R";
                    }
                }
            }
            results.add(count);
        }

        for(int result : results) {
            System.out.print(result + " ");
        }
    }

    public static void findRGB(int row, int col, String color) {
        visited[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if(tempRow >= 0 && tempCol >= 0 && tempRow < size && tempCol < size) {
                if(!visited[tempRow][tempCol] && map[tempRow][tempCol].equals(color)) {
                    findRGB(tempRow, tempCol, color);
                }
            }
        }
    }
}
