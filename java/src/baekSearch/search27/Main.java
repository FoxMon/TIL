package baekSearch.search27;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Map {
    private int row;
    private int col;
    private int count;

    public Map(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getCount() { return this.count; }
}

public class Main {
    public static int size;
    public static int land;
    public static int result = Integer.MAX_VALUE;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        land = 2;
        map = new int[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    group(i, j, map[i][j]);
                    land++;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] >= 2) {
                    visited = new boolean[size][size];
                    bridge(i, j);
                }
            }
        }

        System.out.println(result);
    }

    public static void group(int tempRow, int tempCol, int same) {
        visited[tempRow][tempCol] = true;
        map[tempRow][tempCol] = land;

        for (int i = 0; i < 4; i++) {
            int currentRow = tempRow + dy[i];
            int currentCol = tempCol + dx[i];

            if (currentRow >= 0 && currentCol >= 0 && currentRow < size && currentCol < size) {
                if (!visited[currentRow][currentCol] && map[currentRow][currentCol] == same) {
                    visited[currentRow][currentCol] = true;
                    map[currentRow][currentCol] = land;
                    group(currentRow, currentCol, same);
                }
            }
        }
    }

    public static void bridge(int tempRow, int tempCol) {
        Queue<Map> queue = new LinkedList<>();
        queue.offer(new Map(tempRow, tempCol, 0));
        visited[tempRow][tempCol] = true;
        int currentMap = map[tempRow][tempCol];

        while(!queue.isEmpty()) {
            Map current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < size && currentCol < size) {
                    if(!visited[currentRow][currentCol] && map[currentRow][currentCol] != currentMap) {
                        visited[currentRow][currentCol] = true;
                        if(map[currentRow][currentCol] == 0) {
                            queue.offer(new Map(currentRow, currentCol, current.getCount() + 1));
                        } else {
                            result = Math.min(result, current.getCount());
                        }
                    }
                }
            }
        }
    }
}
