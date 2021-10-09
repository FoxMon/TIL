package baek.babyShark;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

class Find {
    private int row;
    private int col;
    private int distance;

    public Find(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getDistance() { return this.distance; }
}

public class Main {
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };
    public static int n;
    public static int babyRow;
    public static int babyCol;
    public static int size = 2;
    public static int[][] map;
    public static Queue<Node> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        queue = new LinkedList<>();
        babyRow = 0;
        babyCol = 0;

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
        int ate = 0;

        while(true) {
            Find value = find(bfs());

            if(value == null) {
                System.out.println(result);
                System.exit(0);
            } else {
                babyRow = value.getRow();
                babyCol = value.getCol();
                result += value.getDistance();
                map[babyRow][babyCol] = 0;
                ate++;

                if(ate >= size) {
                    size++;
                    ate = 0;
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
                int tempRow = current.getRow() + dy[i];
                int tempCol = current.getCol() + dx[i];

                if(tempRow >= 0 && tempCol >= 0 && tempRow < n && tempCol < n) {
                    if(distance[tempRow][tempCol] == -1 && map[tempRow][tempCol] <= size) {
                        distance[tempRow][tempCol] = distance[current.getRow()][current.getCol()] + 1;
                        queue.offer(new Node(tempRow, tempCol));
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
                if(distance[i][j] != - 1 && map[i][j] >= 1 && map[i][j] < size) {
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
