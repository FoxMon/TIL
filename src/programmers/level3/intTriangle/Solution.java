package programmers.level3.intTriangle;

public class Solution {
    public static int[][] triangleDP;
    public static int[][] trg;
    public static int size;

    public int solution(int[][] triangle) {
        size = triangle.length;
        trg = triangle;
        triangleDP = new int[size][size];

        for(int i = 0; i < size; i++) {
            triangleDP[size - 1][i] = triangle[size - 1][i];
        }

        int answer = findMax(0, 0);
        return answer;
    }

    public int findMax(int row, int col) {
        if(row == size - 1) {
            return triangleDP[row][col];
        }

        if(triangleDP[row][col] == 0) {
            triangleDP[row][col] = Math.max(findMax(row + 1, col), findMax(row + 1, col + 1)) + trg[row][col];
        }

        return triangleDP[row][col];
    }
}
