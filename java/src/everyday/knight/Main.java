package everyday.knight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentPosition = scanner.nextLine();
        int[][] steps = {
                {-2, -1},
                {-1, -2},
                {1, -2},
                {2, -1},
                {2, 1},
                {1, 2},
                {-1, 2},
                {-2, 1},
        };
        int count = 0;
        int currentX = currentPosition.charAt(1) - '0';
        int currentY = currentPosition.charAt(0) - 'a' + 1;

        for(int i = 0; i < steps.length; i++) {
            int nextX = currentX + steps[i][0];
            int nextY = currentY + steps[i][1];

            if(nextX >= 1 && nextX <= 8 && nextY >= 1 && nextX <= 8) {
                count++;
            }
        }

        System.out.println(count);
    }
}
