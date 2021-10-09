package everyday.competitionVirus02;

import java.util.*;

class Node implements Comparable<Node> {
    private int row;
    private int col;
    private int second;
    private int virus;

    public Node(int row, int col, int second, int virus) {
        this.row = row;
        this.col = col;
        this.second = second;
        this.virus = virus;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    public int getSecond() { return this.second; }
    public int getVirus() { return this.virus; }

    @Override
    public int compareTo(Node o) {
        if(this.virus < o.getVirus()) {
            return -1;
        }

        return 1;
    }
}

public class Main {
    public static int n;
    public static int k;
    public static int s, x, y;
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[][] map;
    public static ArrayList<Node> list;
    public static Queue<Node> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        map = new int[n][n];
        list = new ArrayList<>();
        queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();

                if(map[i][j] != 0) {
                    list.add(new Node(i, j, 0, map[i][j]));
                }
            }
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }

        s = scanner.nextInt();
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;

        bfs();
        System.out.println(map[x][y]);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int currentRow = current.getRow();
            int currentCol = current.getCol();
            int currentSecond = current.getSecond();
            int currentVirus = current.getVirus();

            if(currentSecond == s) {
                return;
            }

            for(int i = 0; i < 4; i++) {
                int tempRow = currentRow + dy[i];
                int tempCol = currentCol + dx[i];

                if(tempCol >= 0 && tempRow >= 0 && tempCol < n && tempRow < n) {
                    if(map[tempRow][tempCol] == 0) {
                        map[tempRow][tempCol] = currentVirus;
                        queue.offer(new Node(tempRow, tempCol, currentSecond + 1, currentVirus));
                    }
                }
            }
        }
    }
}
