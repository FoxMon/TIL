package everyday.escape03;

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
    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
}

public class Main {
    public static int rowSize;
    public static int colSize;
    public static int[][] maps;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowSize = scanner.nextInt();
        colSize = scanner.nextInt();
        maps = new int[rowSize][colSize];

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length; j++) {
                maps[i][j] = scanner.nextInt();
            }
        }

        System.out.println(escape(0, 0));
    }

    public static int escape(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, col));

        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tempRow = tempNode.getRow() + dy[i];
                int tempCol = tempNode.getCol() + dx[i];

                if(tempRow < 0 || tempCol < 0 || tempRow > rowSize - 1 || tempCol > colSize - 1) {
                    continue;
                }

                if(maps[tempRow][tempCol] == 0) {
                    continue;
                }

                if(maps[tempRow][tempCol] == 1) {
                    maps[tempRow][tempCol] = maps[tempNode.getRow()][tempNode.getCol()] + 1;
                    queue.offer(new Node(tempRow, tempCol));
                }
            }
        }

        return maps[rowSize - 1][colSize - 1];
    }
}
