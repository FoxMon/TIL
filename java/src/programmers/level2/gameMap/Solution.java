package programmers.level2.gameMap;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    private int row;
    private int col;
    private int distance;

    public Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getDistance() { return this.distance; }
}

public class Solution {
    public static boolean[][] visited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int mapRow;
    public static int mapCol;

    public int solution(int[][] maps) {
        int answer = -1;
        mapRow = maps.length;
        mapCol = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];
        Queue<Node> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Node(0, 0, 1));

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(current.getCol() == mapCol - 1 && current.getRow() == mapRow - 1) {
                answer = current.getDistance();
                return answer;
            }

            for(int i = 0; i < 4; i++) {
                int currentRow = dy[i] + current.getRow();
                int currentCol = dx[i] + current.getCol();

                if(currentRow >= 0 && currentCol >= 0 && currentCol <= mapCol - 1 && currentRow <= mapRow - 1) {
                    if(!visited[currentRow][currentCol] && maps[currentRow][currentCol] == 1) {
                        visited[currentRow][currentCol] = true;
                        queue.offer(new Node(currentRow, currentCol, current.getDistance() + 1));
                    }
                }
            }
        }

        return answer;
    }
}
