package baekSearch.search16rere;

import java.util.PriorityQueue;
import java.util.Scanner;

class Room implements Comparable<Room> {
    private int row;
    private int col;
    private int color;

    public Room(int row, int col, int color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getColor() { return this.color; }

    @Override
    public int compareTo(Room temp) { return this.color - temp.getColor(); }
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
            }
        }

        System.out.println(find(0, 0));
    }

    public static int find(int row, int col) {
        PriorityQueue<Room> queue = new PriorityQueue<>();
        boolean[][] check = new boolean[size][size];
        queue.offer(new Room(row, col, 0));

        while(!queue.isEmpty()) {
            Room current = queue.poll();

            if(current.getRow() == size - 1 && current.getCol() == size - 1) {
                return current.getColor();
            }

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < size && currentCol < size) {
                    if(!check[currentRow][currentCol]) {
                        check[currentRow][currentCol] = true;
                        if(map[currentRow][currentCol] == 0) { // 0 -> black
                            visited[currentRow][currentCol] = current.getColor() + 1;
                            queue.offer(new Room(currentRow, currentCol, visited[currentRow][currentCol]));
                        } else { // 1 -> white
                            visited[currentRow][currentCol] = current.getColor();
                            queue.offer(new Room(currentRow, currentCol, visited[currentRow][currentCol]));
                        }
                    }
                }
            }
        }

        return 0;
    }
}
