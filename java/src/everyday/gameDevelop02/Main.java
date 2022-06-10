package everyday.gameDevelop02;

import java.util.Scanner;

public class Main {
    public static int direction;

    public static void main(String[] args) { // 0, 1, 2, 3
        Scanner scanner = new Scanner(System.in);
        int mapSizeY = scanner.nextInt();
        int mapSizeX = scanner.nextInt();
        int currentY = scanner.nextInt();
        int currentX = scanner.nextInt();
        direction = scanner.nextInt();
        int[][] map = new int[mapSizeY][mapSizeX];
        int[][] visit = new int[mapSizeY][mapSizeX];
        int[] xPosition = { 0, 1, 0, -1 };
        int[] yPosition = { -1, 0, 1, 0 };

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        visit[currentY][currentX] = 1;
        int turnCount = 0;
        int count = 1;

        while(true) {
            turnLeft();
            int tempX = currentX + xPosition[direction];
            int tempY = currentY + yPosition[direction];

            if(visit[tempY][tempX] == 0 && map[tempY][tempX] == 0) {
                currentX = tempX;
                currentY = tempY;
                visit[currentY][currentX] = 1;
                turnCount = 0;
                count++;
            } else {
                turnCount++;
            }

            if(turnCount == 4) {
                tempX = currentX - xPosition[direction];
                tempY = currentY - yPosition[direction];

                if(visit[tempY][tempX] == 0) {
                    currentX = tempX;
                    currentY = tempY;
                } else {
                    break;
                }

                turnCount = 0;
            }
        }

        System.out.println(count);
    }

    public static void turnLeft() {
        direction--;

        if(direction < 0) {
            direction = 3;
        }
    }
}
