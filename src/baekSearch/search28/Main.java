package baekSearch.search28;

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
    public int getTime(){ return this.time; }
}

public class Main {
    public static int row;
    public static int col;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static String[][] map;
    public static Queue<Map> fire = new LinkedList<>();
    public static Queue<Map> me = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int k = 0; k < testCase; k++) { // # wall, . vacant, * fire, @ me
            col = scanner.nextInt();
            row = scanner.nextInt();
            map = new String[row][col];

            for(int i = 0; i < row; i++) {
                String temp = scanner.next();
                for(int j = 0; j < col; j++) {
                    map[i][j] = temp.charAt(j) + "";
                    if(map[i][j].equals("*")) {
                        fire.offer(new Map(i, j, 0));
                    } else if(map[i][j].equals("@")) {
                        me.offer(new Map(i, j, 1));
                    }
                }
            }
            int result = escape();
            me.clear();
            fire.clear();
            if(result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    public static int escape() {
        int answer = -1;

        while(!me.isEmpty()) {
            int fireSize = fire.size();

            for(int k = 0; k < fireSize; k++) {
                Map current = fire.poll();

                for(int i = 0; i < 4; i++) {
                    int currentRow = current.getRow() + dy[i];
                    int currentCol = current.getCol() + dx[i];

                    if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                        if(map[currentRow][currentCol].equals(".")) {
                            map[currentRow][currentCol] = "*";
                            fire.offer(new Map(currentRow, currentCol, 0));
                        }
                    }
                }
            }

            int meSize = me.size();

            for(int k = 0; k < meSize; k++) {
                Map current = me.poll();
                if(current.getRow() == row - 1 || current.getRow() == 0 || current.getCol() == 0 || current.getCol() == col - 1) {
                    answer = current.getTime();
                    return answer;
                }

                for(int i = 0; i < 4; i++) {
                    int currentRow = current.getRow() + dy[i];
                    int currentCol = current.getCol() + dx[i];

                    if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                        if(map[currentRow][currentCol].equals(".")) {
                            map[currentRow][currentCol] = "@";
                            me.offer(new Map(currentRow, currentCol, current.getTime() + 1));
                        }
                    }
                }
            }
        }

        return answer;
    }
}
