package everyday.escape;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static int rowSize;
    public static int colSize;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1 ,1 };

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

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

        int result = bfs(0,0);
        System.out.println(result);
    }

    public static int bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, col));

        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tempX = tempNode.getX() + dx[i];
                int tempY = tempNode.getY() + dy[i];

                if(tempX < 0 || tempY < 0 || tempY > rowSize - 1 || tempX > colSize - 1) {
                    continue;
                }

                if(map[tempY][tempX] == 0) {
                    continue;
                }

                if(map[tempY][tempX] == 1) {
                    map[tempY][tempX] = map[tempNode.getY()][tempNode.getX()] + 1;
                    queue.offer(new Node(tempX, tempY));
                }
            }
        }
        return map[rowSize - 1][colSize - 1];
    }
}
