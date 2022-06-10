package baek.dpRgbDistance03;

import java.util.Scanner;

public class Main {
    public static int RED = 0;
    public static int GREEN = 1;
    public static int BLUE = 2;
    public static int[][] rgbDistance;
    public static int[][] dpRgbDistance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rgbCount = scanner.nextInt();
        rgbDistance = new int[rgbCount][3];
        dpRgbDistance = new int[rgbCount][3];

        for(int i = 0; i < rgbCount; i++) {
            rgbDistance[i][RED] = scanner.nextInt();
            rgbDistance[i][GREEN] = scanner.nextInt();
            rgbDistance[i][BLUE] = scanner.nextInt();
        }

        dpRgbDistance[0][RED] = rgbDistance[0][RED];
        dpRgbDistance[0][GREEN] = rgbDistance[0][GREEN];
        dpRgbDistance[0][BLUE] = rgbDistance[0][BLUE];

        System.out.println(Math.min(findDistance(rgbCount - 1, RED),
                Math.min(findDistance(rgbCount - 1, GREEN), findDistance(rgbCount - 1, BLUE))));
    }

    public static int findDistance(int level, int color) {
        if(dpRgbDistance[level][color] == 0) {
            if(color == RED) {
                dpRgbDistance[level][color] = Math.min(findDistance(level - 1, GREEN),
                        findDistance(level - 1, BLUE)) + rgbDistance[level][RED];
            } else if(color == GREEN) {
                dpRgbDistance[level][color] = Math.min(findDistance(level - 1, RED),
                        findDistance(level - 1, BLUE)) + rgbDistance[level][GREEN];
            } else {
                dpRgbDistance[level][color] = Math.min(findDistance(level - 1, RED),
                        findDistance(level - 1, GREEN)) + rgbDistance[level][BLUE];
            }
        }

        return dpRgbDistance[level][color];
    }
}
