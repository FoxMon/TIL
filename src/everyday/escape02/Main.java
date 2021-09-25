package everyday.escape02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}

public class Main {
    public static int rowSize;
    public static int colSize;
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowSize = scanner.nextInt();
        colSize = scanner.nextInt();
        map = new int[rowSize][colSize];

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        System.out.println(findMap(0, 0 ));
    }

    public static int findMap(int row, int col) {
        Queue<Node> maps = new LinkedList<>();
        maps.offer(new Node(col, row));

        while(!maps.isEmpty()) {
            Node tempNode = maps.poll();

            for(int i = 0; i < 4; i++) {
                int tempX = dx[i] + tempNode.getX();
                int tempY = dy[i] + tempNode.getY();

                if(tempX < 0 || tempY < 0 || tempX > colSize - 1 || tempY > rowSize - 1) {
                    continue;
                }

                if(map[tempY][tempX] == 0) {
                    continue;
                }

                if(map[tempY][tempX] == 1) {
                    map[tempY][tempX] = map[tempNode.getY()][tempNode.getX()] + 1;
                    maps.offer(new Node(tempX, tempY));
                }
            }
        }

        return map[rowSize - 1][colSize - 1];
    }
}
