package everyday.moving;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        scanner.nextLine();
        int x = 1;
        int y = 1;
        String move = scanner.nextLine();
        String[] moves = move.split(" ");

        for(int i = 0; i < moves.length; i++) {
            int tempX = x;
            int tempY = y;
            switch (moves[i]) {
                case "R":
                    tempX = x + 1;
                    break;

                case "L":
                    tempX = x - 1;
                    break;

                case "U":
                    tempY = y - 1;
                    break;

                case "D":
                    tempY = y + 1;
                    break;
            }
            if(tempX < 1 || tempY < 1 || tempX > mapSize || tempY > mapSize) {
                continue;
            }

            x = tempX;
            y = tempY;
        }

        System.out.println(y+ " " + x);
    }
}
