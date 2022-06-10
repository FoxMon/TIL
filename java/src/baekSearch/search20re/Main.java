package baekSearch.search20re;

import java.util.PriorityQueue;
import java.util.Scanner;

class Room implements Comparable<Room> {
    private int row;
    private int col;
    private int broken;

    public Room(int row, int col, int broken) {
        this.row = row;
        this.col = col;
        this.broken = broken;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getBroken() { return this.broken; }

    @Override
    public int compareTo(Room temp) { return this.getBroken() - temp.getBroken(); }
}

public class Main {
    public static int row;
    public static int col;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        col = scanner.nextInt();
        row = scanner.nextInt();
        map = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(temp.charAt(j) + "");
            }
        }

        System.out.println(find(0, 0));
    }

    public static int find(int tempRow, int tempCol) {
        PriorityQueue<Room> queue = new PriorityQueue<>();
        queue.offer(new Room(tempRow, tempCol, 0));
        visited[tempRow][tempCol] = true;

        while(!queue.isEmpty()) {
            Room current = queue.poll();

            if(current.getRow() == row - 1 && current.getCol() == col - 1) {
                return current.getBroken();
            }

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                    if(!visited[currentRow][currentCol]) {
                        if(map[currentRow][currentCol] == 1) {
                            visited[currentRow][currentCol] = true;
                            queue.offer(new Room(currentRow, currentCol, current.getBroken() + 1));
                        } else {
                            visited[currentRow][currentCol] = true;
                            queue.offer(new Room(currentRow, currentCol, current.getBroken()));
                        }
                    }
                }
            }
        }

        return 0;
    }
}
