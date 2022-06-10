package everyday.competitionVirus;

import java.util.*;

class Spread implements Comparable<Spread> {
    int row, col;
    int second;
    int virus;

    public Spread(int row, int col, int second, int virus) {
        this.row = row;
        this.col = col;
        this.second = second;
        this.virus = virus;
    }

    @Override
    public int compareTo(Spread spread) {
        if(this.virus < spread.virus) {
            return -1;
        }

        return 1;
    }
}

public class Main {
    public static int size;
    public static int virus;
    public static int s;
    public static int x;
    public static int y;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int[][] map;
    public static ArrayList<Spread> list = new ArrayList<>();
    public static Queue<Spread> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        virus = scanner.nextInt();
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = scanner.nextInt();

                if(map[i][j] != 0) {
                    list.add(new Spread(i, j, 0, map[i][j]));
                }
            }
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }

        s = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        bfs();

        System.out.println(map[x - 1][y - 1]);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Spread spread = queue.remove();
            int virus = spread.virus;
            int row = spread.row;
            int col = spread.col;
            int second = spread.second;

            if(second == s) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int tempRow = dy[i] + row;
                int tempCol = dx[i] + col;

                if(tempRow < 0 || tempCol < 0 || tempRow >= size || tempCol >= size) {
                    continue;
                }

                if(map[tempRow][tempCol] == 0) {
                    map[tempRow][tempCol] = virus;
                    queue.add(new Spread(tempRow, tempCol, second + 1, virus));
                }
            }
        }
    }
}
