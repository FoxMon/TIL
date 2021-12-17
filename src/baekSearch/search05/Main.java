package baekSearch.search05;

import java.util.Scanner;

public class Main {
    public static int mapSize;
    public static int max = Integer.MIN_VALUE;
    public static int count = 0;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mapSize = scanner.nextInt();
        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];

        for(int i = 0; i < mapSize; i++) {
            for(int j = 0; j < mapSize; j++) {
                map[i][j] = scanner.nextInt();
                max = Math.max(map[i][j], max);
            }
        }

        for(int i = 0; i < max; i++) {
            int result = 0;
            visited = new boolean[mapSize][mapSize];

            for(int j = 0; j < mapSize; j++) {
                for(int k = 0; k < mapSize; k++) {
                    if(map[j][k] > i && !visited[j][k]) {
                        find(j, k, i);
                        result++;
                    }
                }
            }

            count = Math.max(count, result);
        }

        System.out.println(count);
    }

    public static void find(int tempRow, int tempCol, int limit) {
        visited[tempRow][tempCol] = true;

        for(int i = 0; i < 4; i++) {
            int currentRow = tempRow + dy[i];
            int currentCol = tempCol + dx[i];

            if(currentRow >= 0 && currentCol >= 0 && currentRow < mapSize && currentCol < mapSize) {
                if(map[currentRow][currentCol] > limit && !visited[currentRow][currentCol]) {
                    find(currentRow, currentCol, limit);
                }
            }
        }
    }
}
