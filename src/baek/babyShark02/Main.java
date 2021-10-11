package baek.babyShark02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Find {
    private int row;
    private int col;
    private int min;

    public Find(int row, int col, int min) {
        this.row = row;
        this.col = col;
        this.min = min;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getMin() { return this.min; }
}

class Node {
    private int row;
    private int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

public class Main {
    public static int n;
    public static int size;
    public static int babyRow;
    public static int babyCol;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[][] map;
    public static Queue<Node> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        size = 2;
        babyRow = babyCol = 0;
        map = new int[n][n];
        queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();

                if(map[i][j] == 9) {
                    babyRow = i;
                    babyCol = j;
                    map[i][j] = 0;
                }
            }
        }

        int result = 0;
        int count = 0;

        while(true) {
            Find find = find(bfs());

            if(find == null) {
                System.out.println(result);
                System.exit(0);
            } else {
                babyRow = find.getRow();
                babyCol = find.getCol();
                result += find.getMin();
                map[babyRow][babyCol] = 0;
                count++;

                if(count >= size) {
                    count = 0;
                    size++;
                }
            }
        }
    }

    public static int[][] bfs() {
        int[][] distance = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                distance[i][j] = -1;
            }
        }

        queue.offer(new Node(babyRow, babyCol));
        distance[babyRow][babyCol] = 0;

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < n && currentCol < n) {
                    if(distance[currentRow][currentCol] == -1 && map[currentRow][currentCol] <= size) {
                        distance[currentRow][currentCol] = distance[current.getRow()][current.getCol()] + 1;
                        queue.offer(new Node(currentRow, currentCol));
                    }
                }
            }
        }

        return distance;
    }

    public static Find find(int[][] distance) {
        int row = 0;
        int col = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(distance[i][j] != -1 && map[i][j] >= 1 && map[i][j] < size) {
                    if(distance[i][j] < min) {
                        row = i;
                        col = j;
                        min = distance[i][j];
                    }
                }
            }
        }

        if(min == Integer.MAX_VALUE) {
            return null;
        } else {
            return new Find(row, col, min);
        }
    }
}
