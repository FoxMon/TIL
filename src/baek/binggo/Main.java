package baek.binggo;

import java.util.Scanner;

public class Main {
    public static int[][] map = new int[5][5];
    public static int right = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i  = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for(int k = 0; k < 25; k++) {
            int call = scanner.nextInt();
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(map[i][j] == call) {
                        map[i][j] = 0;
                    }
                }
            }

            checkRow(map);
            checkCol(map);
            leftCheck(map);
            rightCheck(map);


            if(right >= 3) {
                System.out.println(k + 1);
                break;
            }

            right = 0;
        }
    }

    public static void checkRow(int[][] map) {
        for(int i = 0; i < 5; i++) {
            int count = 0;
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == 0) {
                    count++;
                }
            }
            if(count == 5) {
                right++;
            }
        }
    }

    public static void checkCol(int[][] map) {
        for(int i = 0; i < 5; i++) {
            int count = 0;
            for(int j = 0; j < 5; j++) {
                if(map[j][i] == 0) {
                    count++;
                }
            }
            if(count == 5) {
                right++;
            }
        }
    }

    public static void leftCheck(int[][] map) {
        int count = 0;
        for(int i = 0; i < 5; i++) {
            if(map[i][i] == 0) {
                count++;
            }
        }
        if(count == 5) {
            right++;
        }
    }

    public static void rightCheck(int[][] map) {
        int count = 0;
        int row = 0;

        for(int i = 4; i >= 0; i--) {
            if(map[row][i] == 0) {
                count++;
            }
            row++;
        }
        if(count == 5) {
            right++;
        }
    }
}
