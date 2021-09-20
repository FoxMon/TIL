package baek.dpGrape;

import java.util.Scanner;

public class Main {
    public static int[] grapes;
    public static Integer[] dpGrapes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grapeCount = scanner.nextInt();
        grapes = new int[grapeCount + 1];
        dpGrapes = new Integer[grapeCount + 1];

        for(int i = 1; i < grapes.length; i++) {
            grapes[i] = scanner.nextInt();
        }

        dpGrapes[0] = grapes[0];
        dpGrapes[1] = grapes[1];

        if(grapeCount >= 2) {
            dpGrapes[2] = grapes[1] + grapes[2];
        }

        System.out.println(drinkGrape(grapeCount));
    }

    public static int drinkGrape(int level) {
        if(dpGrapes[level] == null) {
            dpGrapes[level] = Math.max(Math.max(drinkGrape(level - 2), drinkGrape(level - 3) + grapes[level - 1]) + grapes[level], drinkGrape(level - 1));
        }

        return dpGrapes[level];
    }
}
