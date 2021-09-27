package everyday.antWarrior;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int food = scanner.nextInt();
        int[] foods = new int[food];
        int[] ants = new int[food + 1];

        for(int i = 0; i < foods.length; i++) {
            foods[i] = scanner.nextInt();
        }

        ants[1] = foods[0];
        ants[2] = foods[1];

        for(int i = 3; i <= food; i++) {
            ants[i] = Math.max(ants[i - 1], ants[i - 2] + foods[i - 1]);
        }

        System.out.println(ants[food]);
    }
}
