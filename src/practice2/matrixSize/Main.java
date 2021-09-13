package practice2.matrixSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int[][] matrix;
    public static boolean[][] isVisited;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> sizeArray = new ArrayList<>();
        int matrixSize = scanner.nextInt();
        matrix = new int[matrixSize][matrixSize];
        isVisited = new boolean[matrixSize][matrixSize];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!isVisited[i][j] && matrix[i][j] == 1) {
                    visit(i, j);
                    sizeArray.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(sizeArray);
        System.out.println(sizeArray.size());

        for(int size : sizeArray) {
            System.out.print(size + " ");
        }
    }

    public static void visit(int x, int y) {
        isVisited[x][y] = true;
        matrix[x][y] = 0;

        if(x + 1 < isVisited.length &&  !isVisited[x + 1][y] && matrix[x + 1][y] == 1) { // right
            visit(x + 1, y);
        }

        if(x -1 >= 0 && !isVisited[x - 1][y] && matrix[x - 1][y] == 1) { // left
            visit(x - 1, y);
        }

        if(y + 1 < isVisited.length &&  !isVisited[x][y + 1] && matrix[x][y + 1] == 1) { // top
            visit(x, y + 1);
        }

        if(y - 1 >= 0 &&  !isVisited[x][y - 1] && matrix[x][y - 1] == 1) { // bottom
            visit(x, y - 1);
        }

        count++;
    }
}
