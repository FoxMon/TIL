package programmers.level2.roateArray;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int start = 1;
        int[][] matrix = new int[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = start++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        return answer;
    }

    private int rotate(int[][] matrix, int row1, int col1, int row2, int col2) {
        row1--;
        col1--;
        row2--;
        col2--;

        int temp = matrix[row1][col1];
        int min = temp;

        for(int i = row1; i < row2; i++) { // left
            matrix[i][col1] = matrix[i + 1][col1];
            min = Math.min(min, matrix[i][col1]);
        }

        for(int i = col1; i < col2; i++) { // bottom
            matrix[row2][i] = matrix[row2][i + 1];
            min = Math.min(min, matrix[row2][i]);
        }

        for(int i = row2; i > row1; i--) { // right
            matrix[i][col2] = matrix[i - 1][col2];
            min = Math.min(min, matrix[i][col2]);
        }

        for(int i = col2; i > col1; i--) { // top
            matrix[row1][i] = matrix[row1][i - 1];
            min = Math.min(min, matrix[row1][i]);
        }

        matrix[row1][col1 + 1] = temp;

        return min;
    }
}
