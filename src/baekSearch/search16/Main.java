package baekSearch.search16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Map {
    private int row;
    private int col;
    private int count;
    private int color;

    public Map(int row, int col, int count, int color) {
        this.row = row;
        this.col = col;
        this.count = count;
        this.color = color;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getCount() { return this.count; }
    public int getColor() { return this.color; }
}

public class Main {
    public static int size;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static int[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        map = new int[size][size];
        visited = new int[size][size];

        for(int i = 0; i < size; i++) {
            String temp = scanner.next();
            for(int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(temp.charAt(j) + "");
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(find(0, 0));
    }

    public static int find(int tempRow, int tempCol) {
        Queue<Map> queue = new LinkedList<>();
        queue.offer(new Map(tempRow, tempCol, 0, 0));
        visited[tempRow][tempCol] = 0;

        while(!queue.isEmpty()) {
            Map current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < size && currentCol < size) {
                    if(visited[currentRow][currentCol] <= current.getColor()) {
                        continue;
                    }

                    if(map[currentRow][currentCol] == 0) { // black room
                        visited[currentRow][currentCol] = current.getColor() + 1;
                        queue.offer(new Map(currentRow, currentCol, current.getCount() + 1, current.getColor() + 1));
                    } else { // white room
                        visited[currentRow][currentCol] = current.getColor();
                        queue.offer(new Map(currentRow, currentCol, current.getCount() + 1, current.getColor()));
                    }
                }
            }
        }

        return visited[size - 1][size - 1];
    }
}
