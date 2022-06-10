package everyday.anthena;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] house = new int[count];

        for(int i = 0; i < house.length; i++) {
            house[i] = scanner.nextInt();
        }

        Arrays.sort(house);
        System.out.println(house[(count - 1) / 2]);
    }
}
