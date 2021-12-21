package baekSearch.search15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Map {
    private int row;
    private int col;

    public Map(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

public class Main {
    public static int row;
    public static int col;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;
    public static Queue<Map> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(temp.charAt(j) + "");
            }
        }

        queue.offer(new Map(0, 0));
        System.out.println(find(0, 0));
    }

    public static int find(int tempRow, int tempCol) {
        visited[tempRow][tempCol] = true;

        while(!queue.isEmpty()) {
            Map current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                    if(!visited[currentRow][currentCol] && map[currentRow][currentCol] == 1) {
                        visited[currentRow][currentCol] = true;
                        queue.offer(new Map(currentRow, currentCol));
                        map[currentRow][currentCol] = map[current.getRow()][current.getCol()] + 1;
                    }
                }
            }
        }

        return map[row - 1][col - 1];
    }
}
