package baekSearch.search27re;

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
    public static int min = Integer.MAX_VALUE;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        map = new int[size][size];
        visited = new boolean[size][size];
        land = 2;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    groupLand(i, j);
                    land++;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] >= 2) {
                    visited = new boolean[size][size];
                    makeBridge(i, j);
                }
            }
        }

        System.out.println(min);
    }

    public static void groupLand(int row, int col) {
        visited[row][col] = true;
        map[row][col] = land;

        for(int i = 0; i < 4; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if(tempRow >= 0 && tempCol >= 0 && tempRow < size && tempCol < size) {
                if(!visited[tempRow][tempCol] && map[tempRow][tempCol] == 1) {
                    groupLand(tempRow, tempCol);
                }
            }
        }
    }

    public static void makeBridge(int row, int col) {
        Queue<Map> queue = new LinkedList<>();
        queue.offer(new Map(row, col, 0));
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            Map current = queue.poll();
            int currentLand = map[row][col];

            for(int i = 0; i < 4; i++) {
                int tempRow = current.getRow() + dy[i];
                int tempCol = current.getCol() + dx[i];

                if(tempRow >= 0 && tempCol >= 0 && tempRow < size && tempCol < size) {
                    if(!visited[tempRow][tempCol] && map[tempRow][tempCol] != currentLand) {
                        visited[tempRow][tempCol] = true;

                        if(map[tempRow][tempCol] == 0) {
                            queue.offer(new Map(tempRow, tempCol, current.getCount() + 1));
                        } else {
                            min = Math.min(min, current.getCount());
                        }
                    }
                }
            }
        }
    }
}
