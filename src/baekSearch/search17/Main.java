package baekSearch.search17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Map {
    private int row;
    private int col;
    private int count;

    public Map(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getCount() { return this.count; }
}

public class Main {
    public static int row;
    public static int col;
    public static int result = 0;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static String[][] map;
    public static boolean[][] visited;
    public static Queue<Map> jihun = new LinkedList<>();
    public static Queue<Map> fire = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new String[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j) + "";

                if(map[i][j].equals("J")) { // Ji Hun
                    jihun.offer(new Map(i, j, 0));
                } else if(map[i][j].equals("F")) { // Fire
                    fire.offer(new Map(i, j, 0));
                }
            }
        }

        if(escape()) {
            System.out.println(result);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static boolean escape() {
        while(!jihun.isEmpty()) {
            int target = fire.size();

            for(int k = 0; k < target; k++) {
                Map first = fire.poll();
                for(int i = 0; i < 4; i++) {
                    int tempRow = first.getRow() + dy[i];
                    int tempCol = first.getCol() + dx[i];

                    if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) {
                        if(map[tempRow][tempCol].equals(".")) {
                            map[tempRow][tempCol] = "F";
                            fire.offer(new Map(tempRow, tempCol, first.getCount() + 1));
                        }
                    }
                }
            }

            target = jihun.size();

            for(int k = 0; k < target; k++) {
                Map last = jihun.poll();
                for(int i = 0; i < 4; i++) {
                    int tempRow = last.getRow() + dy[i];
                    int tempCol = last.getCol() + dx[i];

                    if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) {
                        if(map[tempRow][tempCol].equals(".")) {
                            map[tempRow][tempCol] = "J";
                            jihun.offer(new Map(tempRow, tempCol, last.getCount() + 1));
                        }
                    } else {
                        result = last.getCount() + 1;
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
