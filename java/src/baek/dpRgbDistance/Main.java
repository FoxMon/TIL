package baek.dpRgbDistance;

import java.util.Scanner;

public class Main {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    public static int[][] rgb;
    public static int[][] rgbDP;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();

        rgb = new int[caseCount][3];
        rgbDP = new int[caseCount][3];

        for(int i = 0; i < rgb.length; i++) {
            rgb[i][RED] = scanner.nextInt();
            rgb[i][GREEN] = scanner.nextInt();
            rgb[i][BLUE] = scanner.nextInt();
        }

        rgbDP[0][RED] = rgb[0][RED];
        rgbDP[0][GREEN] = rgb[0][GREEN];
        rgbDP[0][BLUE] = rgb[0][BLUE];

        System.out.println(Math.min(findRGB(caseCount - 1, RED),
                Math.min(findRGB(caseCount - 1, GREEN), findRGB(caseCount - 1, BLUE))));
    }

    public static int findRGB(int level, int color) {
        if(rgbDP[level][color] == 0) {
            if(color == RED) {
                rgbDP[level][color] = Math.min(findRGB(level - 1, GREEN), findRGB(level - 1, BLUE)) + rgb[level][RED];
            } else if(color == GREEN) {
                rgbDP[level][color] = Math.min(findRGB(level - 1, RED), findRGB(level - 1, BLUE)) + rgb[level][GREEN];
            } else {
                rgbDP[level][color] = Math.min(findRGB(level - 1, RED), findRGB(level - 1, GREEN)) + rgb[level][BLUE];
            }
        }

        return rgbDP[level][color];
    }
}
