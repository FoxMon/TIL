package baekSearch.search11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int size;
    public static int count;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        ArrayList<Integer> results = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        size = scanner.nextInt();
        map = new int[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++) {
            String input = scanner.next();
            for(int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    find(i, j);
                    total++;
                    results.add(count);
                }
            }
        }

        System.out.println(total);
        Collections.sort(results);
        for(int result : results) {
            System.out.println(result);
        }
    }

    public static void find(int row, int col) {
        visited[row][col] = true;
        count++;

        for(int i = 0; i < 4; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if(tempRow >= 0 && tempCol >= 0 && tempRow < size && tempCol < size) {
                if(!visited[tempRow][tempCol] && map[tempRow][tempCol] == 1) {
                    find(tempRow, tempCol);
                }
            }
        }
    }
}
