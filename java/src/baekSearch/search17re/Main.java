package baekSearch.search17re;

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
    public static int result;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static String[][] map;
    public static Queue<Map> jihun = new LinkedList<>();
    public static Queue<Map> fire = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        result = 0;
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new String[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j) + "";

                if(map[i][j].equals("J")) {
                    jihun.offer(new Map(i, j, 0));
                } else if(map[i][j].equals("F")) {
                    fire.offer(new Map(i, j, 0));
                }
            }
        }

        if(escapeMaze()) {
            System.out.println(result);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static boolean escapeMaze() {
        while(!jihun.isEmpty()) {
            int fireCount = fire.size();

            for(int k = 0; k < fireCount; k++) {
                Map fireTemp = fire.poll();

                for(int i = 0; i < 4; i++) {
                    int tempRow = fireTemp.getRow() + dy[i];
                    int tempCol = fireTemp.getCol() + dx[i];

                    if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) {
                        if(map[tempRow][tempCol].equals(".")) {
                            map[tempRow][tempCol] = "F";
                            fire.offer(new Map(tempRow, tempCol, fireTemp.getCount() + 1));
                        }
                    }
                }
            }

            int jihunCount = jihun.size();

            for(int k = 0; k < jihunCount; k++) {
                Map jihunTemp = jihun.poll();

                for(int i = 0; i < 4; i++) {
                    int tempRow = jihunTemp.getRow() + dy[i];
                    int tempCol = jihunTemp.getCol() + dx[i];

                    if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) {
                        if(map[tempRow][tempCol].equals(".")) {
                            map[tempRow][tempCol] = "J";
                            jihun.offer(new Map(tempRow, tempCol, jihunTemp.getCount() + 1));
                        }
                    } else {
                        result = jihunTemp.getCount() + 1;
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
