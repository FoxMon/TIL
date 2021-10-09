package everyday.virus03;

import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int max = Integer.MIN_VALUE;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[][] map;
    public static int[][] temp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        temp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        dfs(0);
        System.out.println(max);
    }

    public static int getResult() {
        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(temp[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void virus(int row, int col) {
        for(int i = 0; i < 4; i++) {
            int tempRow = row + dy[i];
            int tempCol = col + dx[i];

            if(tempRow >= 0 && tempCol >= 0 && tempRow < n && tempCol < m) {
                if(temp[tempRow][tempCol] == 0) {
                    temp[tempRow][tempCol] = 2;
                    virus(tempRow, tempCol);
                }
            }
        }
    }

    public static void dfs(int count) {
        if(count == 3) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }

            max = Math.max(max, getResult());
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    count++;
                    dfs(count);
                    map[i][j] = 0;
                    count--;
                }
            }
        }
    }
}
