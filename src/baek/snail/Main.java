package baek.snail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int number = scanner.nextInt();
        int start = number * number;
        int target = scanner.nextInt();
        int[][] snail = new int[number][number];
        int row = -1;
        int col = 0;
        int count = 1;

        while(true) {
            for(int i = 0; i < number; i++) {
                row += count;
                snail[row][col] = start--;
            }

            number--;
            if(number == 0) {
                break;
            }

            for(int i = 0; i < number; i++) {
                col += count;
                snail[row][col] = start--;
            }

            count *= -1;
        }

        int targetRow = 0;
        int targetCol = 0;

        for(int i = 0; i < snail.length; i++) {
            for(int j = 0; j < snail[i].length; j++) {
                if(target == snail[i][j]) {
                    targetRow = i + 1;
                    targetCol = j + 1;
                }
                stringBuilder.append(snail[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder.toString());
        System.out.println(targetRow + " " + targetCol);
    }
}
