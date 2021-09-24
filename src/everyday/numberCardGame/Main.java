package everyday.numberCardGame;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] cards = new int[n][m];
        int choice = Integer.MIN_VALUE;

        for(int i = 0; i < cards.length; i++) {
            for(int j = 0; j < cards[i].length; j++) {
                cards[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < cards.length; i++) {
            Arrays.sort(cards[i]);
            choice = cards[i][0];
        }

        System.out.println(choice);
    }
}
