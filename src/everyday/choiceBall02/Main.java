package everyday.choiceBall02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int max = scanner.nextInt();
        int[] balls = new int[total];

        for(int i = 0; i < total; i++) {
            balls[i] = scanner.nextInt();
        }

        int count = 0;

        for(int i = 0; i < total; i++) {
            for(int j = i + 1; j < total; j++) {
                if(balls[i] != balls[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
