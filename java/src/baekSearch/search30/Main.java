package baekSearch.search30;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int row;
    private int col;
    private int distance;

    public Point(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getDistance() { return this.distance; }
}

public class Main {
    public static int row;
    public static int col;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static int[][] results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new int[row][col];
        int startRow = 0;
        int startCol = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
                if(map[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        results = findDistance(startRow, startCol);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 1) {
                    results[i][j] = -1;
                }
                stringBuilder.append(results[i][j] + " ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    public static int[][] findDistance(int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startRow, startCol, 0));
        int[][] result = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        visited[startRow][startCol] = true;
        map[startRow][startCol] = 0;
        result[startRow][startCol] = 0;

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                    if(!visited[currentRow][currentCol] && map[currentRow][currentCol] == 1) {
                        map[currentRow][currentCol] = 0;
                        visited[currentRow][currentCol] = true;
                        result[currentRow][currentCol] = current.getDistance() + 1;
                        queue.offer(new Point(currentRow, currentCol, current.getDistance() + 1));
                    }
                }
            }
        }

        return result;
    }
}
