package everyday.choiceBall;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ballCount = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        int[] balls = new int[ballCount];
        int count = 0;

        for(int i = 0; i < balls.length; i++) {
            balls[i] = scanner.nextInt();
        }

        for(int i = 0; i < ballCount; i++) {
            for(int j = i + 1; j < ballCount; j++) {
                if(balls[i] != balls[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
