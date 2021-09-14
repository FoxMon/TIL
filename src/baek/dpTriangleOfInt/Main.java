package baek.dpTriangleOfInt;

import java.util.Scanner;

public class Main {
    public static int[][] triangle;
    public static Integer[][] triangleDP;
    public static int triangleSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        triangleSize = scanner.nextInt();
        triangle = new int[triangleSize][triangleSize];
        triangleDP = new Integer[triangleSize][triangleSize];

        for(int i = 0; i < triangleSize; i++) {
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < triangleSize; i++) {
            triangleDP[triangleSize - 1][i] = triangle[triangleSize - 1][i];
        }

        System.out.println(findMaxSum(0, 0));
    }

    public static int findMaxSum(int level, int col) {
        if(level - 1 == triangleSize) {
            return triangleDP[level][col];
        }

        if(triangleDP[level][col] == null) {
            triangleDP[level][col] = Math.max(findMaxSum(level + 1, col), findMaxSum(level + 1, col + 1)) + triangle[level][col];
        }

        return triangleDP[level][col];
    }
}
