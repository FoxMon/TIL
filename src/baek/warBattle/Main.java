package baek.warBattle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Soldier {
    private int row;
    private int col;

    public Soldier(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

public class Main {
    public static int row;
    public static int col;
    public static int find = 0;
    public static int blueResult = 0;
    public static int whiteResult = 0;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static char[][] map;
    public static boolean[][] visited;
    public static Queue<Soldier> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        col = scanner.nextInt();
        row = scanner.nextInt();
        map = new char[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            String temp = scanner.next();

            for(int j = 0; j < temp.length(); j++) {
                char character = temp.charAt(j);
                map[i][j] = character;
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    find = 1;
                    queue.offer(new Soldier(i, j));
                    findPower();

                    if(map[i][j] == 'B') {
                        blueResult += (find * find);
                    } else {
                        whiteResult += (find * find);
                    }
                }
            }
        }

        System.out.println(whiteResult + " " + blueResult);
    }

    public static void findPower() {
        while(!queue.isEmpty()) {
            Soldier currentSoldier = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tempRow = currentSoldier.getRow() + dy[i];
                int tempCol = currentSoldier.getCol() + dx[i];

                if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) {
                    if(!visited[tempRow][tempCol] && map[currentSoldier.getRow()][currentSoldier.getCol()] == map[tempRow][tempCol]) {
                        visited[tempRow][tempCol] = true;
                        queue.offer(new Soldier(tempRow, tempCol));
                        find++;
                    }
                }
            }
        }
    }
}
