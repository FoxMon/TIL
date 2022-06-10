package baek.dpTriangleOfInt02;

import java.util.Scanner;

public class Main {
    public static int triangleSize;
    public static int[][] triangle;
    public static Integer[][] dpTriangle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        triangleSize = scanner.nextInt();
        triangle = new int[triangleSize][triangleSize];
        dpTriangle = new Integer[triangleSize][triangleSize];

        for(int i = 0; i < triangleSize; i++) {
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < triangleSize; i++) {
            dpTriangle[triangleSize - 1][i] = triangle[triangleSize - 1][i];
        }

        System.out.println(find(0, 0));
    }

    public static int find(int level, int col) {
        if(level == triangleSize - 1) {
            return dpTriangle[level][col];
        }

        if(dpTriangle[level][col] == null) {
            dpTriangle[level][col] = Math.max(find(level + 1, col), find(level + 1, col + 1)) + triangle[level][col];
        }

        return dpTriangle[level][col];
    }
}
