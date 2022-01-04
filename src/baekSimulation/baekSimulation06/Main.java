package baekSimulation.baekSimulation06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Map {
    private int row;
    private int col;

    public Map(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

public class Main {
    public static int size;
    public static int min;
    public static int max;
    public static int sum = 0;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static boolean[][] visited;
    public static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        min = scanner.nextInt();
        max = scanner.nextInt();
        map = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        System.out.println(move());
    }

    public static int move() {
        int count = 0;
        boolean flag;

        while(true) {
            visited = new boolean[size][size];
            flag = false;

            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(!visited[i][j]) {
                        if(isOpen(i, j)) {
                            flag = true;
                        }
                    }
                }
            }
            if(flag) {
                count++;
            } else {
                return count;
            }
        }
    }

    public static boolean isOpen(int row, int col) {
        Queue<Map> queue = new LinkedList<>();
        Queue<Map> group = new LinkedList<>();
        queue.offer(new Map(row, col));
        group.offer(new Map(row, col));
        visited[row][col] = true;
        sum = map[row][col];

        while(!queue.isEmpty()) {
            Map temp = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tempRow = temp.getRow() + dy[i];
                int tempCol = temp.getCol() + dx[i];

                if(tempRow >= 0 && tempCol >= 0 && tempRow < size && tempCol < size) {
                    if(!visited[tempRow][tempCol]) {
                        int diff = Math.abs(map[tempRow][tempCol] - map[temp.getRow()][temp.getCol()]);
                        if(diff >= min && diff <= max) {
                            sum += map[tempRow][tempCol];
                            queue.offer(new Map(tempRow, tempCol));
                            group.offer(new Map(tempRow, tempCol));
                            visited[tempRow][tempCol] = true;
                        }
                    }
                }
            }
        }

        if(group.size() == 1) {
            return false;
        } else {
            int temp = sum / group.size();
            for(Map mapTemp : group) {
                map[mapTemp.getRow()][mapTemp.getCol()] = temp;
            }

            return true;
        }
    }
}
