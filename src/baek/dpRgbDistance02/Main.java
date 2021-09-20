package baek.dpRgbDistance02;

import java.util.Scanner;

public class Main {
    public static int RED = 0;
    public static int GREEN = 1;
    public static int BLUE = 2;
    public static int[][] rgb;
    public static int[][] dpRgb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        rgb = new int[count][3];
        dpRgb = new int[count][3];

        for(int i = 0; i < count; i++) {
            rgb[i][RED] = scanner.nextInt();
            rgb[i][GREEN] = scanner.nextInt();
            rgb[i][BLUE] = scanner.nextInt();
        }

        dpRgb[0][RED] = rgb[0][RED];
        dpRgb[0][GREEN] = rgb[0][GREEN];
        dpRgb[0][BLUE] = rgb[0][BLUE];

        System.out.println(Math.min(findRGB(count - 1, RED),
                Math.min(findRGB(count - 1, GREEN), findRGB(count - 1, BLUE))));
    }

    public static int findRGB(int level, int color) {
        if(dpRgb[level][color] == 0) {
            if(color == RED) {
                dpRgb[level][color] = Math.min(findRGB(level - 1, GREEN), findRGB(level - 1, BLUE)) + rgb[level][RED];
            } else if(color == GREEN) {
                dpRgb[level][color] = Math.min(findRGB(level - 1, RED), findRGB(level - 1, BLUE)) + rgb[level][GREEN];
            } else {
                dpRgb[level][color] = Math.min(findRGB(level - 1, RED), findRGB(level - 1, GREEN)) + rgb[level][BLUE];
            }
        }

        return dpRgb[level][color];
    }
}
