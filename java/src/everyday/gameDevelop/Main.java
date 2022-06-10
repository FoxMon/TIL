package everyday.gameDevelop;

import java.util.Scanner;

public class Main {
    public static int direction;

    public static void main(String[] args) { // 0 1 2 3 north, east south, west
        Scanner scanner = new Scanner(System.in);
        int mapSizeX = scanner.nextInt();
        int mapSizeY = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        direction = scanner.nextInt();
        int[][] map = new int[mapSizeY][mapSizeX];
        int[][] visit = new int[mapSizeY][mapSizeX];
        int[] xPosition = { -1, 0, 1, 0 }; // north, east south, west
        int[] yPosition = { 0, 1, 0, -1 };

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        visit[y][x] = 1;
        int turn = 0;
        int count = 1;

        while(true) {
            turnLeft();
            int tempX = x + xPosition[direction];
            int tempY = y + yPosition[direction];

            if(visit[tempY][tempX] == 0 && map[tempY][tempX] == 0) {
                visit[tempY][tempX] = 1;
                x = tempX;
                y = tempY;
                count++;
                turn = 0;
                continue;
            } else {
                turn++;
            }

            if(turn == 4) {
                tempX = x - xPosition[direction];
                tempY = y - yPosition[direction];

                if(visit[tempY][tempX] == 0) {
                    x = tempX;
                    y = tempY;
                } else {
                    break;
                }

                turn = 0;
            }
        }

        System.out.println(count);
    }

    public static void turnLeft() {
        direction--;
        if(direction == -1) {
            direction = 3;
        }
    }
}
