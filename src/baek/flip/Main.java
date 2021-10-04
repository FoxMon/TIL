package baek.flip;

import java.util.Scanner;

public class Main {
    public static int[][] coins;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        coins = new int[n][m];
        int count = 0;
        String[][] temp = new String[n][m];

        for(int i =  0; i < n; i++) {
            String str = scanner.next();
            temp[i] = str.split("");
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                coins[i][j] = Integer.parseInt(temp[i][j]);
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(coins[i][j] == 1) {
                    reverse(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void reverse(int row, int col) {
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                coins[i][j] = 1 - coins[i][j];
            }
        }
    }
}
