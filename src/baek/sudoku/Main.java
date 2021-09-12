package baek.sudoku;

import java.util.Scanner;

public class Main {
    public static int[][] sudoku = new int[9][9];
    public static boolean[] isVisited = new boolean[9];
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = scanner.nextInt();
            }
        }

        makeSudoku(0, 0);
    }

    public static void makeSudoku(int row, int col) {
        if(col == 9) {
            makeSudoku(row + 1, 0);
            return;
        }

        if(row == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    stringBuilder.append(sudoku[i][j] + " ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString());
            System.exit(0);
        }

        if(sudoku[row][col] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(isPossible(row, col, i)) {
                    sudoku[row][col] = i;
                    makeSudoku(row, col + 1);
                }
            }

            sudoku[row][col] = 0;
            return;
        }
        makeSudoku(row, col + 1);
    }

    public static boolean isPossible(int row, int col, int target) {
        for(int i = 0; i < 9; i++) {
            if(sudoku[row][i] == target) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == target) {
                return false;
            }
        }

        int start_row = (row / 3) * 3;
        int start_col = (col / 3) * 3;

        for(int i = start_row; i < start_row + 3; i++) {
            for(int j = start_col; j < start_col + 3; j++) {
                if(sudoku[i][j] == target) {
                    return false;
                }
            }
        }

        return true;
    }
}
