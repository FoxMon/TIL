package baekSearch.search08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int row;
    private int col;
    private int cost;

    public Point(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getCost() { return this.cost; }
}

public class Main {
    public static int row;
    public static int col;
    public static int max = 0;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static String[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new String[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j) + "";
            }
        }

        for(int i = 0; i < row; i++) { // 계속 갱신
            for(int j = 0; j < col; j++) {
                if(map[i][j].equals("L")) {
                    visited = new boolean[row][col];
                    int result = find(i, j);
                    max = Math.max(max, result);
                }
            }
        }

        System.out.println(max);
    }

    public static int find(int tempRow, int tempCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(tempRow, tempCol, 0));
        visited[tempRow][tempCol] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                    if(!visited[currentRow][currentCol] && map[currentRow][currentCol].equals("L")) {
                        visited[currentRow][currentCol] = true;
                        queue.offer(new Point(currentRow, currentCol, current.getCost() + 1));
                        count = Math.max(count, current.getCost() + 1);
                    }
                }
            }
        }

        return count;
    }
}
