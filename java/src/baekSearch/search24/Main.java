package baekSearch.search24;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Map {
    private int row;
    private int col;
    private int time;

    public Map(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getTime() { return this.time; }
}

public class Main {
    public static int row;
    public static int col;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static String[][] map;
    public static Queue<Map> water = new LinkedList<>();
    public static Queue<Map> biber = new LinkedList<>();

    public static void main(String[] args) { // stone -> X, water -> *, Biber -> D, target -> S, vacant -> .
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        map = new String[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();
            for(int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j) + "";
                if(temp.charAt(j) == '*') {
                    water.offer(new Map(i, j, 0));
                } else if(temp.charAt(j) == 'S') {
                    biber.offer(new Map(i, j, 0));
                }
            }
        }

        int result = find();

        if(result ==  -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    public static int find() {
        while(!biber.isEmpty()) {
            int first = water.size();

            for(int k = 0; k < first; k++) {
                Map temp = water.poll();

                for(int i = 0; i < 4; i++) {
                    int currentRow = temp.getRow() + dy[i];
                    int currentCol = temp.getCol() + dx[i];

                    if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                        if(map[currentRow][currentCol].equals(".")) {
                            map[currentRow][currentCol] = "*";
                            water.offer(new Map(currentRow, currentCol, temp.getTime() + 1));
                        }
                    }
                }
            }

            first = biber.size();

            for(int k = 0; k < first; k++) {
                Map temp = biber.poll();

                for(int i = 0; i < 4; i++) {
                    int currentRow = temp.getRow() + dy[i];
                    int currentCol = temp.getCol() + dx[i];

                    if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                        if(map[currentRow][currentCol].equals(".")) {
                            map[currentRow][currentCol] = "S";
                            biber.offer(new Map(currentRow, currentCol, temp.getTime() + 1));
                        } else if(map[currentRow][currentCol].equals("D")) {
                            return temp.getTime() + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
