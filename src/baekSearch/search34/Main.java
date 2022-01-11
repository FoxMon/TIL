package baekSearch.search34;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int row;
    private int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

class Coin {
    private int row;
    private int col;
    private int row2;
    private int col2;
    private int count;

    public Coin(int row, int col, int row2, int col2, int count) {
        this.row = row;
        this.col = col;
        this.row2 = row2;
        this.col2 = col2;
        this.count = count;
    }

    public int getRow() { return this.row; }
    public int getRow2() { return this.row2; }
    public int getCol() { return this.col; }
    public int getCol2() { return this.col2; }
    public int getCount() { return this.count; }
}

public class Main {
    public static int row;
    public static int col;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static boolean[][][][] visited;
    public static String[][] map;
    public static Point[] coins;
    public static Queue<Coin> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new String[row][col];
        visited = new boolean[row][col][row][col];
        queue = new LinkedList<>();
        coins = new Point[2];
        int index = 0;

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < temp.length(); j++) {
                map[i][j] = temp.charAt(j) + "";
                if(map[i][j].equals("o")) {
                    coins[index] = new Point(i, j);
                    index++;
                }
            }
        }

        System.out.println(find());
    }

    private static int find() {
        queue.offer(new Coin(coins[0].getRow(), coins[0].getCol(), coins[1].getRow(), coins[1].getCol(), 0));
        visited[coins[0].getRow()][coins[0].getCol()][coins[1].getRow()][coins[1].getCol()] = true;

        while(!queue.isEmpty()) {
            Coin coin = queue.poll();

            if(coin.getCount() >= 10) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int currentRow1 = coin.getRow() + dy[i];
                int currentCol1 = coin.getCol() + dx[i];
                int currentRow2 = coin.getRow2() + dy[i];
                int currentCol2 = coin.getCol2() + dx[i];
                int flag = 0;

                if(!move(currentRow1, currentCol1)) {
                    currentRow1 = coin.getRow();
                    currentCol1 = coin.getCol();
                }

                if(!move(currentRow2, currentCol2)) {
                    currentRow2 = coin.getRow2();
                    currentCol2 = coin.getCol2();
                }

                if(currentRow1 >= 0 && currentCol1 >= 0 && currentRow1 < row && currentCol1 < col) {
                    flag++;
                }

                if(currentRow2 >= 0 && currentCol2 >= 0 && currentRow2 < row && currentCol2 < col) {
                    flag++;
                }

                if(flag == 1) {
                    return coin.getCount() + 1;
                } else if(flag == 2 && !visited[currentRow1][currentCol1][currentRow2][currentCol2]) {
                    visited[currentRow1][currentCol1][currentRow2][currentCol2] = true;
                    queue.offer(new Coin(currentRow1, currentCol1, currentRow2, currentCol2, coin.getCount() + 1));
                }
            }
        }

        return -1;
    }

    private static boolean move(int tempRow, int tempCol) {
        if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col && map[tempRow][tempCol].equals("#")) {
            return false;
        }

        return true;
    }
}
