package baek.maze02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Maze {
    private int row;
    private int col;

    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

public class Main {
    public static boolean[][] visited;
    public static int[][] maze;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int row;
    public static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        maze = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();

            for(int j = 0; j < col; j++) {
                maze[i][j] = temp.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        escapeMaze(0, 0);
        System.out.println(maze[row - 1][col - 1]);
    }

    public static void escapeMaze(int startRow, int startCol) {
        Queue<Maze> queue = new LinkedList<>();
        queue.offer(new Maze(startRow, startCol));

        while(!queue.isEmpty()) {
            Maze current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tempRow = current.getRow() + dy[i];
                int tempCol = current.getCol() + dx[i];

                if(tempRow >= 0 && tempRow < row && tempCol >= 0 && tempCol < col) {
                    if(maze[tempRow][tempCol] == 1 && !visited[tempRow][tempCol]) {
                        maze[tempRow][tempCol] = maze[current.getRow()][current.getCol()] + 1;
                        visited[tempRow][tempCol] = true;
                        queue.offer(new Maze(tempRow, tempCol));
                    }
                }
            }
        }
    }
}
