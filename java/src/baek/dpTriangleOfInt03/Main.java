package baek.dpTriangleOfInt03;

import java.util.Scanner;

public class Main {
    public static int triangleCount;
    public static int[][] triangle;
    public static Integer[][] dpTriangle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        triangleCount = scanner.nextInt();
        triangle = new int[triangleCount][triangleCount];
        dpTriangle = new Integer[triangleCount][triangleCount];

        for(int i = 0; i < triangle.length; i++) {
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < triangleCount; i++) {
            dpTriangle[triangleCount - 1][i] = triangle[triangleCount - 1][i];
        }

        System.out.println(findMaxTriangle(0, 0));
    }

    public static int findMaxTriangle(int level, int col) {
        if(level == triangleCount - 1) {
            return dpTriangle[level][col];
        }

        if(dpTriangle[level][col] == null) {
            dpTriangle[level][col] = Math.max(findMaxTriangle(level + 1, col),
                    findMaxTriangle(level + 1, col + 1)) + triangle[level][col];
        }

        return dpTriangle[level][col];
    }
}
