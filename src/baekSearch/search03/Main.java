package baekSearch.search03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
    private int row;
    private int col;

    public Tomato(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

public class Main {
    public static int[][] map;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static Queue<Tomato> queue = new LinkedList<>();
    public static int row;
    public static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        col = scanner.nextInt();
        row = scanner.nextInt();
        map = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = scanner.nextInt();
                if(map[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }

        System.out.println(find());
    }

    public static int find() {
        while(!queue.isEmpty()) {
            Tomato temp = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tempRow = temp.getRow() + dy[i];
                int tempCol = temp.getCol() + dx[i];

                if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) {
                    if(map[tempRow][tempCol] == 0) {
                        map[tempRow][tempCol] = map[temp.getRow()][temp.getCol()] + 1;
                        queue.offer(new Tomato(tempRow, tempCol));
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 0) {
                    return -1;
                }

                result = Math.max(result, map[i][j]);
            }
        }

        if(result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}
