package baek.attachNumber02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int mapSize;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;
    public static int count = 0;
    public static int result = 0;
    public static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mapSize = scanner.nextInt();
        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];

        for(int i = 0; i < mapSize; i++) {
            String temp = scanner.next();

            for(int j = 0; j < temp.length(); j++) {
                map[i][j] = Integer.parseInt(temp.charAt(j) + "");
            }
        }

        for(int i = 0; i < mapSize; i++) {
            for(int j = 0; j < mapSize; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                    results.add(result);
                    result = 0;
                }
            }
        }

        System.out.println(count);
        Collections.sort(results);

        for(int number : results) {
            System.out.println(number);
        }
    }

    public static void dfs(int row, int col) {
        map[row][col] = 0;
        visited[row][col] = true;
        result++;

        for(int i = 0; i < 4; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if(tempRow >= 0 && tempCol >= 0 && tempRow < mapSize && tempCol < mapSize) {
                if(map[tempRow][tempCol] == 1 && !visited[tempRow][tempCol]) {
                    dfs(tempRow, tempCol);
                }
            }
        }
    }
}
