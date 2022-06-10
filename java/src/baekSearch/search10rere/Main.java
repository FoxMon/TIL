package baekSearch.search10rere;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Map {
    private int row;
    private int col;
    private int cost;
    private int broken;

    public Map(int row, int col, int cost, int broken) {
        this.row = row;
        this.col = col;
        this.cost = cost;
        this.broken = broken;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getCost() { return this.cost; }
    public int getBroken() { return this.broken; }
}

public class Main {
    public static int row;
    public static int col;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static int[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new int[row][col];
        visited = new int[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(temp.charAt(j) + "");
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(find(0, 0));
    }

    public static int find(int tempRow, int tempCol) {
        Queue<Map> queue = new LinkedList<>();
        queue.offer(new Map(tempRow, tempCol, 1, 0));

        while(!queue.isEmpty()) {
            Map current = queue.poll();

            if(current.getRow() == row - 1 && current.getCol() == col - 1) {
                return current.getCost();
            }

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                    if(visited[currentRow][currentCol] > current.getBroken()) {
                        if(map[currentRow][currentCol] == 0) {
                            visited[currentRow][currentCol] = current.getBroken();
                            queue.offer(new Map(currentRow, currentCol, current.getCost() + 1, current.getBroken()));
                        } else {
                            if(current.getBroken() == 0) {
                                visited[currentRow][currentCol] = current.getBroken() + 1;
                                queue.offer(new Map(currentRow, currentCol, current.getCost() + 1, current.getBroken() + 1));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}
